package fr.paquet.dataBase;

import java.util.HashMap;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;

public class Connect {

	/**
	 * @author Nathanael
	 * 
	 *         Connection a la base de donnees<br/>
	 */

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	private static PrepareConnection PConnexion = null;

	/**
	 * 
	 * @return la connection a la base de donnee "derby"<br/>
	 *         url de la db jdbc:postgresql://localhost:5432/sequence
	 * @throws Exception
	 */
	public static EntityManagerFactory getEmf() throws Exception {
		if (emf == null) {

			Map<String, String> properties = new HashMap<String, String>();

			properties.put(PersistenceUnitProperties.ECLIPSELINK_PERSISTENCE_XML, "META-INF/persistence.xml");
			properties.put(PersistenceUnitProperties.JDBC_USER, getPConnexion().getUser().getUtilisateur());
			properties.put(PersistenceUnitProperties.JDBC_PASSWORD, getPConnexion().getUser().getPass());
			properties.put(PersistenceUnitProperties.JDBC_URL, "jdbc:postgresql://localhost:5432/sequence");
			properties.put(PersistenceUnitProperties.JDBC_DRIVER, "org.postgresql.Driver");

			emf = Persistence.createEntityManagerFactory("sequence", properties);
			// emf.getPersistenceUnitUtil();
			// emf.getMetamodel();
		}
		return emf;
	}

	/**
	 * 
	 * @return entity manager unique<br/>
	 * @throws Exception
	 */
	public static EntityManager getEm() throws Exception {
		if (em == null)
			em = getEmf().createEntityManager();
		return em;
	}

	public static PrepareConnection getPConnexion() {
		return PConnexion;
	}

	public static void setPConnexion(PrepareConnection pConnexion) {
		Connect.PConnexion = pConnexion;
	}

}
