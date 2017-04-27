package uo.sdi.messages.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class Messages {

	private static final String JMS_CONNECTION_FACTORY = "java:/ConnectionFactory";

	private static Connection con;
	private static Session session;
	private static MessageProducer sender;

	public static void send(MapMessage msg) {
		try {
			initialize();
			sender.send(msg);
			close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void close() throws JMSException {
		con.close();
		session.close();
		sender.close();
	}

	private static void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		con.start();
	}

	public static TextMessage createTextMessage() {
		try {
			initialize();
			return session.createTextMessage();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Destination getTemporaryQueue() {
		try {
			initialize();
			return session.createTemporaryQueue();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static MessageConsumer createConsumer(Destination dest) {
		try {
			initialize();
			return session.createConsumer(dest);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static MessageProducer createProducer(Destination dest){
		try {
			initialize();
			return session.createProducer(dest);
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return sender;
	}

}
