package cn.tekin.springcloud_providerticket.service;

import org.springframework.stereotype.Service;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-23 13:28
 */
@Service
public class TicketService {
    public String getTicket(){
        System.out.println("8001");
        return "《厉害了，我的国》 server:8001";
    }
}
