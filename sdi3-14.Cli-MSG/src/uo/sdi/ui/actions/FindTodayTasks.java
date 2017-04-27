package uo.sdi.ui.actions;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import uo.sdi.ui.actions.util.Jndi;
import uo.sdi.ui.actions.util.Messages;
import alb.util.menu.Action;

public class FindTodayTasks implements Action, MessageListener {

	@Override
	public void execute() throws Exception {
		initialize();
		
		Destination tempQueue = session.createTemporaryQueue();
		MessageConsumer responseConsumer = session.createConsumer(tempQueue);

		responseConsumer.setMessageListener(this);
		
		MapMessage msg = Messages.createMapMessage();
		msg.setString("command", "getTareas");
		msg.setString("userId", "5019");
		
		msg.setJMSReplyTo(tempQueue);
		msg.setJMSCorrelationID("findTasks");

		this.sender.send(msg);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onMessage(Message m) {
		ObjectMessage msg = (ObjectMessage) m;
		try {
			List<String> tareas = (ArrayList<String>) msg.getObject();
			
			for(String t : tareas)
				System.out.println(t);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
	
	private static final String JMS_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
	private static final String NOTANEITOR_QUEUE = "jms/queue/NotaneitorQueue";

	private Connection con;
	private Session session;
	private MessageProducer sender;

	private void showMessage(MapMessage msg) throws JMSException {
		System.out.println(msg.getString("command"));
		System.out.println(msg.getString("iduser"));
		System.out.println(msg.getString("email"));
		System.out.println(msg.getString("name"));
		System.out.println(msg.getString("surname"));
		System.out.println();
	}

	private void close() throws JMSException {
		con.close();
		session.close();
		sender.close();
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


}
