# Springboot Dubbo整合

## Dubbo POM依赖

新版本 Dubbo pom依赖,
与dubbo 0.1 版本不同的是新版本dubbo 2.x 使用 curator作为ZooKeeper连接客户端
~~~xml
<!-- https://mvnrepository.com/artifact/org.apache.dubbo/dubbo-spring-boot-starter -->
		<dependency>
			<groupId>org.apache.dubbo</groupId>
			<artifactId>dubbo-spring-boot-starter</artifactId>
			<version>2.7.3</version>
		</dependency>
		<!--		zookeeper的客户端连接工具 curator -->
		<!-- https://mvnrepository.com/artifact/org.apache.curator/curator-framework -->
		<dependency>
			<groupId>org.apache.curator</groupId>
			<artifactId>curator-framework</artifactId>
			<version>4.2.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.curator/curator-recipes -->
		<dependency>
			<groupId>org.apache.curator</groupId>
			<artifactId>curator-recipes</artifactId>
			<version>4.2.0</version>
		</dependency>

~~~

Dubbo 0.1.0版本 POM依赖
~~~xml
		<!-- https://mvnrepository.com/artifact/org.apache.dubbo/dubbo-spring-boot-starter -->
	<dependency>
			<groupId>com.alibaba.boot</groupId>
			<artifactId>dubbo-spring-boot-starter</artifactId>
			<version>0.1.0</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/com.github.sgroschupf/zkclient -->
		<dependency>
			<groupId>com.github.sgroschupf</groupId>
			<artifactId>zkclient</artifactId>
			<version>0.1</version>
		</dependency>
~~~

## Dubbo 配置文件

配置文件 application.yml
~~~yaml
#for dubbo 2.x
dubbo:
  application:
    name: springboot-dubbo_provider-ticket
    id: springboot-dubbo_provider-ticket
  registry:
    address: zookeeper://127.0.0.1:2181
    group: springboot
    timeout: 5000
  scan:
    base-packages: cn.tekin.dubbo.ticket.service
  provider:
    threadpool: fixed
    threads: 10
~~~

properties格式配置文件
~~~properties
dubbo.application.id=springboot-dubbo_provider-ticket
dubbo.application.name=springboot-dubbo_provider-ticket
dubbo.registry.address=zookeeper://127.0.0.1:2181
dubbo.provider.threads=10
dubbo.provider.threadpool=fixed
dubbo.server=true
dubbo.protocol.name=dubbo
dubbo.protocol.port=-1
dubbo.registry.group=spring
dubbo.registry.timeout=5000
dubbo.scan.base-packages=cn.tekin.dubbo.ticket.service

~~~



旧版本dubbo配置文件 application.yml
~~~yaml
# for dubbo 0.1.0
dubbo:
  application:
    name: springboot-dubbo_provider-ticket
  registry:
    address: zookeeper://127.0.0.1:2181
  scan:
    base-packages: cn.tekin.dubbo.ticket.service
~~~


## notice

provider  与consumer端的 全路径必须完全一致，否则consumer无法调用！！！

如：provider端发布的包 cn.tekin.dubbo.ticket.service 中的 TicketService 

客户端接收的也必须是  cn.tekin.dubbo.ticket.service 包中的 TicketService


