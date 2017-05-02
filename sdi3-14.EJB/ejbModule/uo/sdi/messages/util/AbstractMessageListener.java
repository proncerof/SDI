package uo.sdi.messages.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import uo.sdi.business.exception.BusinessException;

public abstract class AbstractMessageListener implements MessageListener {

	private static final String JMS_CONNECTION_FACTORY = "java:/ConnectionFactory";
	private static final String JMS_AUDIT_QUEUE = "java:jboss/exported/jms/queue/ErrorQueue";

	private Connection con;
	private Session session;
	private MessageProducer responseProducer, errorSender;

	@Override
	public void onMessage(Message m) {
		System.out.println("GTDListener: Msg received");
		try {
			if (messageOfExpectedType(m))
				process((MapMessage) m);
		} catch (BusinessException e) {
			try {
				TextMessage errorMessage = session.createTextMessage();
				errorMessage.setText(e.getMessage());
				errorSender.send(errorMessage);
			} catch (JMSException jex) {
				e.printStackTrace();
			}

		} catch (JMSException jex) {
			
		}
	}

	private boolean messageOfExpectedType(Message m) {
		return m instanceof MapMessage;
	}

	public void process(MapMessage message) throws BusinessException,
			JMSException {
		initialize();

		ObjectMessage response = session.createObjectMessage();

		createResponse(message, response);
		
		response.setJMSCorrelationID(message.getJMSCorrelationID());

		responseProducer = session.createProducer(message.getJMSReplyTo());

		responseProducer.send(response);

		close();
	}

	private void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		Destination errorQueue = (Destination) Jndi.find(JMS_AUDIT_QUEUE);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		errorSender = session.createProducer(errorQueue);
		con.start();
	}

	private void close() throws JMSException {
		con.close();
		session.close();
		responseProducer.close();
	}
	
	protected void sendErrorMessage(String message){
		try {
			TextMessage m = session.createTextMessage();
			m.setText(message);
			errorSender.send(m);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	protected abstract void createResponse(MapMessage message, ObjectMessage msg)
			throws JMSException, BusinessException;

}
