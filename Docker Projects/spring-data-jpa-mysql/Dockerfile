# 1. mvn package
# 2. docker run -d -p 6033:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=book_manager" mysql
# 3. docker build -t springio/gs-spring-boot-docker .
# 4. docker run -t --link docker-mysql:mysql -p 10222:10222 springio/gs-spring-boot-docker

FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} spring-data-jpa-mysql-1.0.jar
ENTRYPOINT ["java","-jar","/spring-data-jpa-mysql-1.0.jar"]