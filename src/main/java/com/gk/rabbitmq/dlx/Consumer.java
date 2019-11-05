package com.gk.rabbitmq.dlx;

import com.gk.rabbitmq.util.RabbitUtil;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @Description: TODO
 * @Author: GK
 * @Date: 2019/11/5
 */
@Slf4j
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitUtil.getConnection();
        Channel channel = connection.createChannel();
        String exchangeName = "test_dlx_exchange";
        String queueName = "test_dlx_queue";
        String routingKey = "dlx.#";
        Map<String,Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange","dlx.exchange");

        // 申明交换机
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueDeclare(queueName,true,false,false,arguments);
        channel.queueBind(queueName,exchangeName,routingKey);

        //申明死信队列
        channel.exchangeDeclare("dlx.exchange", BuiltinExchangeType.TOPIC,true,false,null);
        channel.queueDeclare("dlx.queue",true,false,false,null);
        channel.queueBind("dlx.queue","dlx.exchange","#");

        com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body,"UTF-8");
                log.info("延时队列测试消息接收成功，接收消息：{}",message);
            }
        };
        boolean autoAck = true;
        channel.basicConsume(queueName, autoAck, consumer);//autoAck=false时为手动ACK
    }
}
