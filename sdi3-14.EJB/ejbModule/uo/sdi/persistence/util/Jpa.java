package uo.sdi.persistence.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;

import alb.util.jdbc.Jdbc;
import uo.sdi.persistence.PersistenceException;

public class Jpa {
	private static final String QUERIES_PROPERTIES_FILE = "sql_queries.properties";

	private static ThreadLocal<EntityManager> emThread = new ThreadLocal<EntityManager>();
	private static Properties sqlQueries = loadProperties(QUERIES_PROPERTIES_FILE);

	public static EntityManager getManager() {
		EntityManager entityManager = emThread.get();
		if (entityManager == null) {
			entityManager = jndiFind("java:/JpaEntityManager");
			emThread.set(entityManager);
		}
		return entityManager;
	}

	private static EntityManager jndiFind(String name) {
		Context ctx;
		try {
			ctx = new InitialContext();
			return (EntityManager) ctx.lookup(name);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getSqlQuery(String queryKey) {
		return sqlQueries.getProperty(queryKey).trim();
	}

	private static Properties loadProperties(String fileName) {
		Properties prop = new Properties();
		InputStream stream = Jdbc.class.getClassLoader().getResourceAsStream(
				fileName);
		try {
			prop.load(stream);
		} catch (IOException e) {
			throw new PersistenceException("Wrong configutation file "
					+ fileName);
		}
		return prop;
	}
}
