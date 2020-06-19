FROM openjdk:11
ADD ./target/abc-0.0.1-SNAPSHOT.jar abc-0.0.1-SNAPSHOT.jar
EXPOSE 8585
ENTRYPOINT ["java","-jar","abc-0.0.1-SNAPSHOT.jar"]
