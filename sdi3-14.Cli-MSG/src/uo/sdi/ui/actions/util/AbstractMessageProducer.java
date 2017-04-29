package uo.sdi.ui.actions.util;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;

import uo.sdi.ui.actions.LoginAction;
import alb.util.menu.Action;

public abstract class AbstractMessageProducer implements Action{

	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String NOTANEITOR_QUEUE = "jms/queue/NotaneitorQueue";

	private Connection con;
	private Session session;
	private MessageProducer sender;

	@Override
	public void execute() throws Exception {
		initialize();

		Destination tempQueue = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempQueue);

		responseConsumer.setMessageListener(getListener());

		MapMessage msg = session.createMapMessage();
		createMessage(msg);
		
		LoginAction.addAuthentication(msg);

		msg.setJMSReplyTo(tempQueue);
		msg.setJMSCorrelationID(createRandomString());

		sender.send(msg);
			
		close();
	}

	private void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		Destination queue = (Destination) Jndi.find(NOTANEITOR_QUEUE);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		sender = session.createProducer(queue);
		con.start();
	}
	
	private void close() throws JMSException {
		con.close();
		session.close();
		sender.close();
	}

	private String createRandomString() {
		Random random = new Random(System.currentTimeMillis());
		long randomLong = random.nextLong();
		return Long.toHexString(randomLong);
	}
	
	protected abstract MessageListener getListener();
	protected abstract void createMessage(MapMessage msg) throws JMSException;

}
