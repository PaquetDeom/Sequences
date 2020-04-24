package fr.paquet.dataBase.Factory.commun;

import java.util.EnumSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.QueryFindAll;

public abstract class Factory {

	public Factory() {
		super();
	}

	public List<? extends Object> findAll() throws Exception {

		String queryString = null;

		for (QueryFindAll qE : EnumSet.allOf(QueryFindAll.class)) {
			if (qE.getClassObject() == getClassObject()) {
				queryString = qE.getQuery();
				break;
			}
		}

		Query query = Connect.getEm().createQuery(queryString);

		@SuppressWarnings("unchecked")
		List<Object> objects = (List<Object>) query.getResultList();
		if (objects.isEmpty())
			throw new Exception("Il n'y a pas d'objet de type" + getClassObject() + "dans la base de donnee");
		return objects;
	}

	public abstract Class<?> getClassObject();

	private void test(Object object) throws Exception {
		if (object.getClass() != getClassObject())
			throw new Exception("L'objet n'est pas de type " + getClassObject());
	}

	public void persist(Object object) throws Exception {

		test(object);
		EntityManager em = Connect.getEm();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.persist(object);
			em.flush();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	public void remove(Object object) throws Exception {

		test(object);

		EntityManager em = Connect.getEm();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			em.remove(object);
			em.flush();
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

}
