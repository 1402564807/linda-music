package com.linda.lindamusic.utils;

import com.linda.lindamusic.enums.FileType;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * 文件类型转换器
 *
 * @author 林思涵
 * @date 2022/03/29
 */
public class FileTypeTransformer {

    public static FileType getFileTypeFromExt(String ext) {
        if (isAudio(ext)) {
            return FileType.AUDIO;
        }

        if (isImage(ext)) {
            return FileType.IMAGE;
        }

        if (isVideo(ext)) {
            return FileType.VIDEO;
        }

        return FileType.OTHER;
    }

    private static Boolean isVideo(String ext) {
        var videoExt = new String[]{"vob", "mp4", "avi",
                "flv", "f4v", "wmv", "mov", "rmvb",
                "mkv", "mpg", "m4v", "webm", "rm",
                "mpeg", "asf", "ts", "mts"};
        for (var perExt : videoExt) {
            if (perExt.equals(ext))
                return TRUE;
        }
        return FALSE;
    }

    private static Boolean isAudio(String ext) {
        var videoExt = new String[]{"mp3", "wav"};
        for (var perExt : videoExt) {
            if (perExt.equals(ext))
                return TRUE;
        }
        return FALSE;
    }


    private static Boolean isImage(String ext) {
        var videoExt = new String[]{"png", "jpg", "jpeg"};
        for (var perExt : videoExt) {
            if (perExt.equals(ext))
                return TRUE;
        }
        return FALSE;
    }


}