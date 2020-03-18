package fr.paquet.dataBase;

import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.paquet.io.dataBase.ReadTxtUser;

public class Connect {

	/**
	 * @author Nathanael
	 * 
	 *         Connection a la base de donnees<br/>
	 */

	private static EntityManagerFactory emf = null;
	private EntityManager em = null;
	private static User user = null;
	private static Connect connect = null;

	private Connect() throws Exception {
		super();
		createUser();
		DriverManager.getConnection("jdbc:postgresql://localhost:5432/sequence", user.getUtilisateur(), user.getPass());
	}

	public static Connect getUniqInstance() throws Exception {
		if (connect == null)
			connect = new Connect();
		return connect;
	}

	private void createUser() throws Exception {

		ReadTxtUser rt = new ReadTxtUser();
		setUser(new User(rt.getLines().get(0), rt.getLines().get(1)));

	}

	/**
	 * 
	 * @return la connection a la base de donnee "derby"<br/>
	 *         url de la db jdbc:hsqldb:hsql://localhost:5434/sequences
	 */
	public static EntityManagerFactory getEmf() {
		if (emf != null && emf.isOpen())
			return emf;
		else
			emf = Persistence.createEntityManagerFactory("sequence");

		return emf;

	}

	/**
	 * 
	 * @return entity manager unique<br/>
	 */
	public EntityManager getEm() {
		if (em == null)
			em = getEmf().createEntityManager();
		return em;
	}

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		Connect.user = user;
	}

}
