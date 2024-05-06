# 基础镜像
FROM  openjdk:11-jre
# author
MAINTAINER aiit

# 挂载目录
VOLUME /home/aiit
# 创建目录
RUN mkdir -p /home/aiit
# 指定路径
WORKDIR /home/aiit
# 复制jar文件到路径
COPY aiit-hexlab-admin.jar /home/aiit/aiit-hexlab-admin.jar
# 启动认证服务
ENTRYPOINT ["java","-jar","-Xms128m","-Xmx256m","aiit-hexlab-admin.jar"]