package com.gk.rabbitmq.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitUtil {
	
	public static Connection getConnection() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
//		factory.setVirtualHost("/virtual_gktest");
//		factory.setUsername("gaokai");
//		factory.setPassword("123456");
		factory.setVirtualHost("/");
		factory.setUsername("guest");
		factory.setPassword("guest");
		Connection connection = factory.newConnection();
		return connection;
	}

}
