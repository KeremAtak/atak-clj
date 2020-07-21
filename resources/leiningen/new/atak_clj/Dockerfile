FROM openjdk:8-alpine

COPY target/uberjar/swagger-example.jar /swagger-example/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/swagger-example/app.jar"]
