FROM openjdk:17-jdk

# Jar 파일의 위치
ARG JAR_FILE=build/libs/*.jar
# ARG P12_FILE=p12/*.p12
# app.jar는 경우에 따라 이름 변경
COPY ${JAR_FILE} app.jar
#COPY p12/*.p12 keystore.p12
# 생략 가능 - 해당 컨테이너는 8080 port 를 사용한다는 의미.
EXPOSE 8080

# docker run 시 실행할 필수 명령어
#ENTRYPOINT ["java", "-Dserver.ssl.key-store=/keystore.p12", "-Dserver.ssl.key-store-type=PKCS12", "-Dserver.ssl.key-store-password=724705as++", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]