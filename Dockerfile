FROM openjdk:11
COPY ./target/abc-0.0.1-SNAPSHOT.jar abc-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","abc-0.0.1-SNAPSHOT.jar"]