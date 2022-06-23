FROM openjdk:8
VOLUME /temp
EXPOSE 8080
ADD ./target/service-client-0.0.1-SNAPSHOT.jar client.jar
ENTRYPOINT ["java","-jar","client.jar"]