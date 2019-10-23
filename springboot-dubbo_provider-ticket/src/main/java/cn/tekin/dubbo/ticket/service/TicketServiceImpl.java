package cn.tekin.dubbo.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-23 09:48
 */
@Component //加入到sp容器中
@Service //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "恭喜，你买到票了";
    }
}
