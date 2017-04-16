package uo.sdi.infrastructure;

import uo.sdi.business.ServicesFactory;
import uo.sdi.persistence.PersistenceFactory;

public class Factories {

	private static String CONFIG_FILE = "/factories.properties";

	public static ServicesFactory services = (ServicesFactory) FactoriesHelper
			.createFactory(CONFIG_FILE, "SERVICES_FACTORY");

	public static PersistenceFactory persistence = (PersistenceFactory) FactoriesHelper
			.createFactory(CONFIG_FILE, "PERSISTENCE_FACTORY");
}
