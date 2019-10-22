package cn.tekin.rabbitmq.service;


import cn.tekin.rabbitmq.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Author Tekin <tekintian@gmail.com>
 * @Create 2019-10-22 14:07
 */
@Service
public class BookService {
    /**
     * 接收消息 对象
     * @param book
     */
    @RabbitListener(queues = "queue01")
    public void receive(Book book){
        System.out.println("收到消息"+book);
    }

    /**
     * 接收消息 message
     * @param message
     */
    @RabbitListener(queues = "queue01")
    protected void receive2(Message message) {
        System.out.println("message");
        System.out.println(message.getBody());
        System.out.println(message.toString());
    }
}
