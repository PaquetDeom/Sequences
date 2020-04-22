package fr.paquet.dataBase.Factory.sequence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.SequenceImpl;

public class SequenceImplFactory extends Factory {

	public SequenceImpl findSequenceImplByTitle(String title) throws Exception {

		Query query = Connect.getEm()
				.createQuery("SELECT sequenceImpl FROM SequenceImpl sequenceImpl WHERE sequenceImpl.titre=:title");
		query.setParameter("title", title);

		try {
			SequenceImpl seqImpl = (SequenceImpl) query.getSingleResult();
			return seqImpl;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Class<?> getClassObject() {

		return SequenceImpl.class;
	}

}
