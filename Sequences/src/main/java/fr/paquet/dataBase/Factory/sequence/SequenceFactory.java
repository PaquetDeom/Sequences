package fr.paquet.dataBase.Factory.sequence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.Sequence;

public class SequenceFactory extends Factory {

	public Sequence findSequenceByTitle(String title) throws Exception {

		Query query = Connect.getEm().createQuery("SELECT sequence FROM Sequence sequence WHERE sequence.titre=:title");
		query.setParameter("title", title);

		try {
			Sequence seq = (Sequence) query.getSingleResult();
			return seq;
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public Class<?> getClassObject() {
		return Sequence.class;
	}

}
