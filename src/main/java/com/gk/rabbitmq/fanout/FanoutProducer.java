package com.gk.rabbitmq.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgProducer;
import com.rabbitmq.client.BuiltinExchangeType;

/**
 * Exchange为Fanout类型的生产者
 * @Title: FanoutProducer.java  
 * @Package com.gk.rabbitmq.fanout  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class FanoutProducer {
	
	private static final String EXCHANGE_NAME = "gktest.fanout";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		for(int i = 0; i < 10; i++) {
			String message = "RabbitMQ Fanout Exchange" + i;
			String routingKey = "fanout" + i;
			MsgProducer.produceMsg(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, routingKey, message);
		}
	}

}
