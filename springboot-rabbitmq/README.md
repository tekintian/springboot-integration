# Springboot RabbitMQ 整合

## 引入依赖
~~~xml
 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-amqp</artifactId>
        </dependency>
~~~

 
## 配置
1、RabbitAutoConfiguration
2、有自动配置了连接工厂ConnectionFactory；
3、RabbitProperties 封装了 RabbitMQ的配置
4、 RabbitTemplate ：给RabbitMQ发送和接受消息；
5、 AmqpAdmin ： RabbitMQ系统管理功能组件;
 	AmqpAdmin：创建和删除 Queue，Exchange，Binding
6、@EnableRabbit +  @RabbitListener 监听消息队列的内容

7. 在springboot入口文件中开启基于注解的RabbitMQ模式
@EnableRabbit


## 接收消息
~~~java
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
~~~

## 交换器和消息队列创建与绑定，消息发送
~~~java
// 部分核心测试代码

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange() {
        //创建一个 direct exchange   exchange01
      amqpAdmin.declareExchange(new DirectExchange("exchange01"));
      //创建一个queue  exchange01
      amqpAdmin.declareQueue(new Queue("queue01"));

      //绑定 queue01 到 exchange01上面
      amqpAdmin.declareBinding(
              new Binding("queue01",Binding.DestinationType.QUEUE,"exchange01","queue01",null)
      );

    }

    @Test
    public void sendMsgTest() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("msg","消息测试");
//        map.put("content", Arrays.asList("中国","云南","昆明"));
//
//       rabbitTemplate.convertAndSend("queue01",map);
//
       rabbitTemplate.convertAndSend("exchange.topic","tekin.news",new Book("三国演义","吴承恩"));

    }

    //接受数据,如何将数据自动的转为json发送出去
	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("queue01");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	/**
	 * 广播
	 */
	@Test
	public void sendMsg(){
		rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
	}
~~~


