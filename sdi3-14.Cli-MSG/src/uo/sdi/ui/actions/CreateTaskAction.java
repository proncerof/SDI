package uo.sdi.ui.actions;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;

import alb.util.console.Console;
import alb.util.date.DateUtil;
import uo.sdi.ui.actions.util.AbstractMessageListener;

public class CreateTaskAction extends AbstractMessageListener{

	@Override
	protected void processResponse(ObjectMessage message) throws JMSException {
		String respuesta = (String) message.getObject();
		System.out.println("\n"+respuesta);
	}

	@Override
	protected void createMessage(MapMessage msg) throws JMSException {
		String title = Console.readString("Titulo");
		Console.println("Fecha planeada");
		int day = Console.readInt("\tDia");
		int month = Console.readInt("\tMes");
		int year = Console.readInt("\tAño");
		
		Date planned = DateUtil.fromDdMmYyyy(day, month, year);
		
		msg.setString("command", "newTask");
		msg.setLong("userId",5019);
		msg.setString("title", title);
		msg.setLong("planned", planned.getTime());
	}

}
