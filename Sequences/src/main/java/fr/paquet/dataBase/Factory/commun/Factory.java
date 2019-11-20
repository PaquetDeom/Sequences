package fr.paquet.dataBase.Factory.commun;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;

public abstract class Factory extends Connect {

	public Factory() {
		super();
	}

	public List<? extends Object> findAll() throws Exception {

		if (getClassObject() == null)
			throw new Exception("Vous n'avez pas saisi de nom de class");

		Query query = getEm().createQuery("SELECT obj FROM" + getClassObject() + "obj");

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

		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().persist(object);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

	public void remove(Object object) throws Exception {

		test(object);
		
		EntityTransaction t = getEm().getTransaction();

		try {
			t.begin();
			getEm().remove(object);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			throw (e);
		}

	}

}
