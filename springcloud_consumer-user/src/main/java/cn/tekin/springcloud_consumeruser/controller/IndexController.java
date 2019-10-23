package cn.tekin.springcloud_consumeruser.controller;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-23 13:47
 */
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
