FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY gradlew settings.gradle.kts build.gradle.kts ./
COPY gradle ./gradle
COPY domain/build.gradle.kts ./domain/
COPY data/build.gradle.kts ./data/
COPY api/build.gradle.kts ./api/
COPY app/build.gradle.kts ./app/
RUN ./gradlew dependencies --no-daemon || true
COPY . .
RUN ./gradlew :app:bootJar --no-daemon

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
