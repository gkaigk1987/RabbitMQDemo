package com.gk.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.RabbitUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

/**
 * 简单队列消费者
 * @Title: SimpleRecieve.java  
 * @Package com.gk.rabbitmq.simple  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月4日
 */
public class SimpleRecieve {
	
	private final static String QUEUE_NAME01 = "gktest_01";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		Connection connection = RabbitUtil.getConnection();
		//创建消息通道
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME01, false, false, false, null);
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				String msg = new String(body,"UTF-8");
				System.out.println(msg);
			}
		};
		
		channel.basicConsume(QUEUE_NAME01, true, consumer);
	}

}
