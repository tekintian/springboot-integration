package cn.tekin.springcloud_providerticket.controller;

import cn.tekin.springcloud_providerticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-23 13:30
 */
@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public String getTicket() {
        return ticketService.getTicket();
    }
}

