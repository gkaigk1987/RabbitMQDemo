package com.gk.rabbitmq.dlx;

import com.gk.rabbitmq.util.RabbitUtil;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.impl.AMQBasicProperties;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 延迟队列-死信队列
 * @Author: GK
 * @Date: 2019/11/5
 */
@Slf4j
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_dlx_exchange";
        String routingKey = "dlx.send";

        for(int i = 1; i < 6; i++) {
            String msg = "Hello RabbitMQ DLX message " + i;
            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .deliveryMode(2)    //持久化
                    .contentEncoding("UTF-8")
                    .expiration("10000")    //10S后过期
                    .build();
            channel.basicPublish(exchangeName,routingKey,true,properties,msg.getBytes());
            log.info("延时队列测试消息发送成功，发送消息：{}",msg);
        }
        channel.close();
        connection.close();
    }
}
