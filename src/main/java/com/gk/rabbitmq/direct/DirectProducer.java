package com.gk.rabbitmq.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgProducer;
import com.rabbitmq.client.BuiltinExchangeType;

/**
 * Exchange为Direct类型的生产者
 * @Title: DirectProducer.java  
 * @Package com.gk.rabbitmq.direct  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class DirectProducer {
	
	private static final String EXCHANGE_NAME = "gktest.direct";

	public static void main(String[] args) throws IOException, TimeoutException {
		String message = "RabbitMQ Direct Exchange";
		String routingKey = "direct";
		MsgProducer.produceMsg(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, routingKey, message);
	}
	
}
