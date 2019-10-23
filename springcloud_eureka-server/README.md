# SpringCloud 分布式 之 Eureka注册中心

Eureka 注册中心配置
~~~yaml
server:
  port: 8761
eureka:
  instance:
    hostname: eureka-server  # eureka实例的主机名, 必须参照域名的命名标准，不能有下划线_，否则客户端无法连接
  client:
    register-with-eureka: false #不把自己注册到eureka上
    fetch-registry: false #不从eureka上来获取服务的注册信息
    service-url:
      defaultZone: http://localhost:8761/eureka/
~~~


客户端采用RestTemplate连接的连接地址为,eureka注册中心的 Application名称，
即：PROVIDER-TICKET 【eureka server服务的hostname大写】
~~~

    @Autowired
    RestTemplate restTemplate;

    public String getTicket(){
     String s = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
      return s;
    }

~~~

