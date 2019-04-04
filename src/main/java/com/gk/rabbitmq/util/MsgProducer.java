package com.gk.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class MsgProducer {
	
	public static void produceMsg(String exchange, BuiltinExchangeType exchangeType,String routingKey,String message) throws IOException, TimeoutException {
		Connection connection = RabbitUtil.getConnection();
		//创建消息通道
		Channel channel = connection.createChannel();
		//声明交换机
		channel.exchangeDeclare(exchange, exchangeType, true, false, null);
		//发布消息
		channel.basicPublish(exchange, routingKey, null, message.getBytes());
		System.out.println("[Exchange="+exchange+",ExchangeType="+exchangeType.getType()+",RoutingKey="+routingKey+"发送消息：]" + message);
		channel.close();
		connection.close();
	}

}
