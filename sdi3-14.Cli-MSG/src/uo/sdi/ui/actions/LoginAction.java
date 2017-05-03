package uo.sdi.ui.actions;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;

import uo.sdi.ui.actions.util.AbstractMessageProducer;
import alb.util.console.Console;

public class LoginAction extends AbstractMessageProducer {

	private static String login;
	private static String password;

	public static void addAuthentication(MapMessage msg) throws JMSException{
		msg.setString("login", login);
		msg.setString("password", password);
	}

	@Override
	protected void processResponse(ObjectMessage message) throws JMSException {
		Boolean respuesta = (Boolean) message.getObject();
		if(respuesta){
			System.out.println("\nLogin correcto");
		}else
			System.out.println("\nLogin incorrecto");	
	}

	@Override
	protected void createMessage(MapMessage msg) throws JMSException {
		login = Console.readString("Login");
		password = Console.readString("Password");
		
		msg.setString("command", "login");
	}

}
