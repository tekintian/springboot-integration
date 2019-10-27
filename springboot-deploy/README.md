



jar Docker容器镜像创建


Package打包后,将jar文件放到与 Dockerfile同一目录下
target/springboot-deploy-0.0.1-SNAPSHOT.jar
~~~Dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD springboot-deploy-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
~~~

运行Docker镜像创建命令
~~~shell script
docker build -f Dockerfile -t myjavaapp .
~~~ 
