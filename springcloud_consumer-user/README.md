# springcloud Eureka 消费者

## 消费服务入口
~~~java

@SpringBootApplication
@EnableDiscoveryClient //开启发现服务功能
public class SpringcloudConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConsumerUserApplication.class, args);
	}

	/**
	 * 借助 RestTemplate发送http请求来调用远程服务内容,
	 * @see https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
	 * https://zhuanlan.zhihu.com/p/31681913
	 */
	@LoadBalanced //启用负载均衡机制
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
~~~


## 消费
~~~java
@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String buyTicket(String name){
        String forObject = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
    return name+"购买了"+forObject;
    }
}
~~~







restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);  URL地址



![resttemplate_url](/Users/Tekin/src/java_demo/springboot-integration/springcloud_consumer-user/resttemplate_url.png)