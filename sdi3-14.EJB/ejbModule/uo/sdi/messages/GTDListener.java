package uo.sdi.messages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import uo.sdi.business.TaskService;
import uo.sdi.business.exception.BusinessException;
import uo.sdi.dto.Task;
import uo.sdi.infrastructure.Factories;
import uo.sdi.messages.util.Jndi;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/NotaneitorQueue") })
public class GTDListener implements MessageListener {

	private static final String JMS_CONNECTION_FACTORY = "java:/ConnectionFactory";

	private static Connection con;
	private static Session session;
	private static MessageProducer responseProducer;

	private TaskService service = Factories.services.getTaskService();

	@Override
	public void onMessage(Message msg) {
		System.out.println("NotaneitorListener: Msg received");
		try {
			process(msg);
		} catch (JMSException jex) {
			jex.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private void process(Message m) throws BusinessException, JMSException {
		if (!messageOfExpectedType(m)) {
			System.out.println("Not of expected type " + m);
			return;
		}
		
		initialize();
		
		MapMessage msg = (MapMessage) m;
		String cmd = msg.getString("command");
		
		ObjectMessage response = session.createObjectMessage();
		
		if(cmd.equals("getTareas")){
			List<String> tareas = new ArrayList<>();
			for(Task t : service.findTodayTasksByUserId(msg.getLong("userId")))
					tareas.add(t.toString());
			response.setObject((Serializable) tareas);
		}
		
		response.setJMSCorrelationID(msg.getJMSCorrelationID());

		responseProducer = session.createProducer(msg
				.getJMSReplyTo());

		responseProducer.send(response);

		close();
	}

	private boolean messageOfExpectedType(Message m) {
		return m instanceof MapMessage;
	}

	private static void initialize() throws JMSException {
		ConnectionFactory factory = (ConnectionFactory) Jndi
				.find(JMS_CONNECTION_FACTORY);
		con = factory.createConnection("sdi", "password");
		session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
		con.start();
	}
	
	private static void close() throws JMSException {
		con.close();
		session.close();
		responseProducer.close();
	}

}