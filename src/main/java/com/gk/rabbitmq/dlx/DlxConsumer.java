package com.gk.rabbitmq.dlx;

import com.gk.rabbitmq.util.RabbitUtil;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 消费死信队列
 * @Author: GK
 * @Date: 2019/11/5
 */
@Slf4j
public class DlxConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("dlx.queue",true,false,false,null);
        channel.queueBind("dlx.queue","dlx.exchange","#");
        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body,"UTF-8");
                log.info("死信队列测试消息接收成功，接收消息：{}",message);
            }
        };
        boolean autoAck = true;
        channel.basicConsume("dlx.queue", autoAck, consumer);//autoAck=false时为手动ACK
    }
}
