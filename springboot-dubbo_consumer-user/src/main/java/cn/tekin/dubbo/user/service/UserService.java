package cn.tekin.dubbo.user.service;

import cn.tekin.dubbo.ticket.service.TicketService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-23 09:50
 */
@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello(){

        String ticket = ticketService.getTicket();
        System.out.println("Hello "+ticket + " User:"+ticketService.getUser());
    }
}
