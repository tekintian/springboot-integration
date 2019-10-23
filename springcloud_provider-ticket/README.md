# SpringCloud 生产者

 SpringBoot 2.2.0.RELEASE
 SpringCloud Hoxton.M3


快速部署多个生产者应用，
更改应用的端口号后，打包应用为jar, 然后在运行相应的JAR即可部署相同应用到Eureka服务中心


~~~shell
java -jar /pathttojar/xxx.jar
~~~

配置
~~~yaml
server:
  port: 8001
spring:
  application:
    name: provider-ticket
# eureka配置
eureka:
  instance:
    prefer-ip-address: true # 注册服务的时候使用服务的IP地址
  client:
    service-url:
      defaultZone: http://localhost:8761/eureka/
~~~

POM依赖, 注意最新版本的 artifactId与老版本有区别，最新版为：spring-cloud-starter-netflix-eureka-client 需要springboot >2.x
旧版： spring-cloud-starter-eureka 这个在新版本已经被废弃！Spring Cloud Starter Eureka (deprecated, please use spring-cloud-starter-netflix-eureka-client
~~~xml
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    <version>2.1.3.RELEASE</version>
</dependency>

~~~

