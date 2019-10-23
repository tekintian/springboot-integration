package cn.tekin.springcloud_consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
