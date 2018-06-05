package com.gk.rabbitmq.simple;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.RabbitUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 简单队列生产者
 * @Title: SimpleProducer.java  
 * @Package com.gk.rabbitmq.simple  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月4日
 */
public class SimpleProducer {
	
	private final static String QUEUE_NAME01 = "gktest_01";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		Connection connection = RabbitUtil.getConnection();
		//创建消息通道
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME01, false, false, false, null);
		
		String msg = "gktest01_msg";
				
		channel.basicPublish("", QUEUE_NAME01, null, msg.getBytes());
		
		channel.close();
		connection.close();
		
	}

}
