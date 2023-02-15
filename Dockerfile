# 基础镜像
FROM openjdk:8-jre-slim
# 作者
MAINTAINER hukki
# 配置
ENV PARAMS=""
# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 添加应用
ADD /chatbot-assistant-interfaces/target/chatbot-assistant.jar /chatbot-assistant.jar
# 执行镜像
ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /chatbot-assistant.jar $PARAMS"]