package com.gk.rabbitmq.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgConsumer;

/**
 * Exchange为Fanout类型的消费者
 * @Title: FanoutConsumer.java  
 * @Package com.gk.rabbitmq.fanout  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class FanoutConsumer {
	
	private static final String EXCHANGE_NAME = "gktest.fanout";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		for(int i = 0; i < 10; i++) {
			String queue = "fanout.queue" + (i % 2);
			String routingKey = "fanout" + i;
			MsgConsumer.comsumeMsg(EXCHANGE_NAME, queue, routingKey);
		}
	}

}
