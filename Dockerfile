FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} algalogApi.jar
ENTRYPOINT ["java","-jar","algalogApi.jar"]