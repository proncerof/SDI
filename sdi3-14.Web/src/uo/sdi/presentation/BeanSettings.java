package uo.sdi.presentation;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import alb.util.log.Log;
import alb.util.log.LogLevel;


public class BeanSettings implements Serializable {
	private static final long serialVersionUID = 2L;
	private static final Locale ENGLISH = new Locale("en");
	private static final Locale SPANISH = new Locale("es");
	private static final Locale FRENCH = new Locale("fr");
	private Locale locale = new Locale("en");

	@PostConstruct
	public void start() {
		Log.setLogLevel(LogLevel.DEBUG);
	}

	// Es sólo a modo de traza.
	@PreDestroy
	public void end() {
		System.out.println("BeanSettings - PreDestroy");
	}

	public Locale getLocale() {
		// Aqui habria que cambiar algo de código para coger locale del
		// navegador
		// la primera vez que se accede a getLocale(), de momento dejamos como
		// idioma departida “es”
		return (locale);
	}

	public void setSpanish(ActionEvent event) {
		locale = SPANISH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setEnglish(ActionEvent event) {
		locale = ENGLISH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void setFrench(ActionEvent event) {
		locale = FRENCH;
		try {
			FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}