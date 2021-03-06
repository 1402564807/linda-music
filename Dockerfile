# 写在最前面：强烈建议先阅读官方教程[Dockerfile最佳实践]（https://docs.docker.com/develop/develop-images/dockerfile_best-practices/）
# 选择构建用基础镜像（选择原则：在包含所有用到的依赖前提下尽可能提及小）。如需更换，请到[dockerhub官方仓库](https://hub.docker.com/_/java?tab=tags)自行选择后替换。
FROM gradle:jdk17 as build

# 指定构建过程中的工作目录
WORKDIR /app

# 将src目录下所有文件，拷贝到工作目录中src目录下
COPY src /app/src

# 将pom.xml文件，拷贝到工作目录下
COPY --chown=gradle:gradle . /app

# 执行代码编译命令
RUN gradle build --refresh-dependencies -Dspring.profiles.active=prod

# 选择运行时基础镜像
FROM alpine:3.15

# 安装依赖包，如需其他依赖包，请到alpine依赖包管理(https://pkgs.alpinelinux.org/packages?name=php8*imagick*&branch=v3.13)查找。
RUN apk add --update --no-cache openjdk17 \
    && rm -f /var/cache/apk/*

# 指定运行时的工作目录
WORKDIR /app

# 将构建产物jar包拷贝到运行时目录中
COPY --from=build /app/build/libs/linda-music.jar .

# 暴露端口
EXPOSE 80

# 执行启动命令
CMD ["java", "-jar", "/app/linda-music.jar", "--spring.profiles.active=prod"]