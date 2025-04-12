# 1. Java 17 기반 이미지 사용
FROM openjdk:17-jdk-slim

# 2. JAR 파일을 컨테이너에 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 3. 포트 오픈 (필요시)
EXPOSE 8083

# 4. 실행 명령어
ENTRYPOINT ["java", "-jar", "/app.jar"]
