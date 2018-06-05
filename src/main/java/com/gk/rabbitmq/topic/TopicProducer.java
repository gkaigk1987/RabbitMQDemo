package com.gk.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgProducer;
import com.rabbitmq.client.BuiltinExchangeType;

/**
 * 
 * @Title: TopicProducer.java  
 * @Package com.gk.rabbitmq.topic  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class TopicProducer {
	private static final String EXCHANGE_NAME = "gktest.topic";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		String[] routingKey = new String[]{"log","error.log","info.log","auth.gk","auth.A"};
		for (String key : routingKey) {
			String message = "Topic Message => " + key;
			MsgProducer.produceMsg(EXCHANGE_NAME, BuiltinExchangeType.TOPIC, key, message);
		}
	}
	
}
