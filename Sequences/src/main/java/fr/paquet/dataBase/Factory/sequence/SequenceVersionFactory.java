package fr.paquet.dataBase.Factory.sequence;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.SequenceVersion;

public class SequenceVersionFactory extends Factory {

	public SequenceVersion findSequenceVersionByTitle(String title) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.titre=:title");
		query.setParameter("title", title);

		try {
			SequenceVersion sequenceVersion = (SequenceVersion) query.getSingleResult();
			return sequenceVersion;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Class<?> getClassObject() {
		return SequenceVersion.class;
	}

}
