package com.linda.lindamusic.service.Impl;


import com.linda.lindamusic.dto.FileUploadDto;
import com.linda.lindamusic.exception.BizException;
import com.linda.lindamusic.service.StorageService;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import static com.linda.lindamusic.exception.ExceptionType.INNER_ERROR;
import static com.qcloud.cos.http.HttpMethodName.GET;
import static com.tencent.cloud.CosStsClient.getCredential;

/**
 * cos存储服务impl
 *
 * @author 林思涵
 * @date 2022/03/29
 */
@Service("COS")
public class CosStorageServiceImpl implements StorageService {

    @Value("${cos.bucket}")
    private String bucket;

    @Value("${cos.secret-id}")
    private String secretId;

    @Value("${cos.secret-key}")
    private String secretKey;

    @Value("${cos.region}")
    private String region;

    @Override
    public FileUploadDto initFileUpload() {
        try {
            var response = getCredential(getCosStsConfig());
            var fileUploadDto = new FileUploadDto();
            fileUploadDto.setSecretId(response.credentials.tmpSecretId);
            fileUploadDto.setSecretKey(response.credentials.tmpSecretKey);
            fileUploadDto.setSessionToken(response.credentials.sessionToken);
            fileUploadDto.setStartTime(response.startTime);
            fileUploadDto.setExpiredTime(response.expiredTime);
            return fileUploadDto;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException(INNER_ERROR);
        }
    }

    @Override
    public String getFileUri(String fileKey) {
        var cosClient = createCOSClient();
        var expirationDate = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        var params = new HashMap<String, String>();
        var headers = new HashMap<String, String>();
        var url = cosClient.generatePresignedUrl(bucket, fileKey, expirationDate, GET, headers, params);
        cosClient.shutdown();
        return url.toString();
    }

    private TreeMap<String, Object> getCosStsConfig() {
        var config = new TreeMap<String, Object>();
        config.put("secretId", secretId);
        config.put("secretKey", secretKey);

        // 临时密钥有效时长，单位是秒
        config.put("durationSeconds", 1800);
        config.put("allowPrefixes", new String[]{
                "*"
        });
        config.put("bucket", bucket);
        config.put("region", region);
        String[] allowActions = new String[]{
                // 简单上传
                "name/cos:PutObject",
                "name/cos:PostObject",
                // 分片上传
                "name/cos:InitiateMultipartUpload",
                "name/cos:ListMultipartUploads",
                "name/cos:ListParts",
                "name/cos:UploadPart",
                "name/cos:CompleteMultipartUpload"
        };
        config.put("allowActions", allowActions);
        return config;
    }


    // Todo: 改造client获取方法
    public COSClient createCOSClient() {
        // 这里需要已经获取到临时密钥的结果。
        // 临时密钥的生成参考 https://cloud.tencent.com/document/product/436/14048#cos-sts-sdk

        var cred = new BasicCOSCredentials(secretId, secretKey);

        // ClientConfig 中包含了后续请求 COS 的客户端设置：
        var clientConfig = new ClientConfig();

        // 设置 bucket 的地域
        // COS_REGION 请参照 https://cloud.tencent.com/document/product/436/6224
        clientConfig.setRegion(new Region(region));

        // 设置请求协议, http 或者 https
        // 5.6.53 及更低的版本，建议设置使用 https 协议
        // 5.6.54 及更高版本，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);

        // 以下的设置，是可选的：

        // 设置 socket 读取超时，默认 30s
        clientConfig.setSocketTimeout(30 * 1000);
        // 设置建立连接超时，默认 30s
        clientConfig.setConnectionTimeout(30 * 1000);

        return new COSClient(cred, clientConfig);
    }
}

