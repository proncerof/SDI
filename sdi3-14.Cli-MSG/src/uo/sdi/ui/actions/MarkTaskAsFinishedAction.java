package uo.sdi.ui.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;

import uo.sdi.ui.actions.util.AbstractMessageListener;
import alb.util.console.Console;

public class MarkTaskAsFinishedAction extends AbstractMessageListener{

	@Override
	protected void processResponse(ObjectMessage message) throws JMSException {
		String respuesta = (String) message.getObject();
		System.out.println("\n"+respuesta);
	}

	@Override
	protected void createMessage(MapMessage msg) throws JMSException {
		Long taskId = Console.readLong("Id de la tarea");
		msg.setString("command", "finishTask");
		msg.setLong("taskId", taskId);
	}

}
