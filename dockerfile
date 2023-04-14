FROM maven as build

WORKDIR /app

COPY . .

RUN mvn clean package

FROM openjdk:17-jdk-slim as production

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]