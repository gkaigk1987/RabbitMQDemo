package com.gk.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class MsgConsumer {
	
	public static void comsumeMsg(String exchange, String queue, String routingKey) throws IOException, TimeoutException {
		Connection connection = RabbitUtil.getConnection();
		//创建消息通道
		Channel channel = connection.createChannel();
		//声明队列
		channel.queueDeclare(queue, true, false, false, null);
		//绑定队列到交换机
		channel.queueBind(queue, exchange, routingKey);
		
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String message = new String(body,"UTF-8");
				System.out.println("[Exchange="+exchange+",Queue="+queue+",RoutingKey="+routingKey+"接受到消息：]" + message);
//				channel.basicAck(envelope.getDeliveryTag(), false);//此设置为手动ACK
			}
		};
		boolean autoAck = true;
		channel.basicConsume(queue, autoAck, consumer);//autoAck=false时为手动ACK
	}

}
