# SpringBoot + SpringSecurity 整合演示

演示了Spring Boot+Spring Security + MySql实现用户权限管理





~~~yaml
spring:
  jpa:
    database-platform: org.hibernate.dialect.MySQLDialect
    show-sql: true
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        hbm2ddl:
          auto: update
  datasource:
    url: jdbc:mysql://localhost:3357/spring_security?useSSL=false
    username: demo
    password: demodemo
    driver-class-name: com.mysql.jdbc.Driver
  jackson:
    serialization:
      indent-output: true
logging:
  level:
    org.springframework.data: DEBUG

~~~


SpringBoot 1.x 与 2.x版本 JPA分页区别

~~~java
// springboot 1.5.x版本方法
   Pageable pageable = new PageRequest(page,size, Sort.Direction.ASC, "id");

//新版本 Spring Boot 2.x JPA分页 PageRequest.of代替过时的PageRequest方法
   Sort sort = Sort.by(Sort.Direction.DESC, "id");
   Pageable pageable = PageRequest.of(0, 10, sort);

~~~