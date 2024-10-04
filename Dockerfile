 FROM openjdk:21
 USER root
 ENV RUN_SCHEDULE=true
 ENV DB_HOST=172.17.0.2
 ENV DB_NAME=zoom
 ENV DB_USERNAME=postgres
 ENV DB_PASSWORD=zoom
 ENV DB_PORT=5432
 #COPY /target/userservice.jar /usr/src/userservice.jar
 ADD zoom-0.0.1-SNAPSHOT.jar zoom.jar
 ENTRYPOINT exec java -jar -Dspring.profiles.active=release  zoom.jar

