FROM amazoncorretto:17-alpine-jdk
LABEL authors="wesleyvlk"
MAINTAINER Wesley VLK <wesleymuniz20@gmail.com>
WORKDIR /app/
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY /build/libs/*.jar api-languages.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar api-languages.jar