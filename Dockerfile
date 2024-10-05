FROM maven:3.9.4-amazoncorretto-20 AS MAVEN_BUILD
ARG BUILD_ID=0.0.1-SNAPSHOT
COPY pom.xml /build/
COPY src /build/src/
RUN mkdir -p /root/.m2 \  && mkdir /root/.m2/repository
COPY settings-local.xml /root/.m2
COPY settings.xml /usr/share/maven/conf/settings.xml
WORKDIR /build/
RUN mvn clean package -DskipTests  -Dbuild.version=${BUILD_ID} -ntp

FROM openjdk:20
USER root
RUN mkdir /opt/bucket
ENV DB_HOST=185.215.187.106
ENV DB_NAME=ksolutions
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=ksolutions
ENV DB_PORT=5432
ARG BUILD_ID=0.0.1-SNAPSHOT
RUN mkdir -p /app && mkdir -p /app/config
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/zoom-${BUILD_ID}.jar /app/zoom.jar
EXPOSE 8080

ENTRYPOINT exec java -jar -Dspring.profiles.active=release  zoom.jar