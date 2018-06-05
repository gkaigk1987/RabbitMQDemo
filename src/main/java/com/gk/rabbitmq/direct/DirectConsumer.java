package com.gk.rabbitmq.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgConsumer;

/**
 * Exchange为Direct类型的消费者
 * @Title: DirectConsumer.java  
 * @Package com.gk.rabbitmq.direct  
 * @Description: TODO
 * @author GK 
 * @date 2018年6月5日
 */
public class DirectConsumer {
	
	private static final String EXCHANGE_NAME = "gktest.direct";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		MsgConsumer.comsumeMsg(EXCHANGE_NAME, "direct.queue", "direct");
	}

}
