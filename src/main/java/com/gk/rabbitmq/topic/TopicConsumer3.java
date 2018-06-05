package com.gk.rabbitmq.topic;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgConsumer;

/**
 * 
 * @Title: TopicConsumer.java  
 * @Package com.gk.rabbitmq.topic  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class TopicConsumer3 {
	
	private static final String EXCHANGE_NAME = "gktest.topic";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		String queue = "topic.queue3";
		String routingKey = "auth.#";
		MsgConsumer.comsumeMsg(EXCHANGE_NAME, queue, routingKey);
	}

}
