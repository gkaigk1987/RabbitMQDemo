package com.gk.rabbitmq.direct;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.gk.rabbitmq.util.MsgConsumer;

public class DirectConsumer {
	
	private static final String EXCHANGE_NAME = "gktest.direct";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		MsgConsumer.comsumeMsg(EXCHANGE_NAME, "direct.queue", "direct");
	}

}
