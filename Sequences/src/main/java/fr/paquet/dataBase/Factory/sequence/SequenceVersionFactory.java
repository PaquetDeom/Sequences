package fr.paquet.dataBase.Factory.sequence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.Auteur;
import fr.paquet.sequence.SequenceImpl;
import fr.paquet.sequence.SequenceVersion;

public class SequenceVersionFactory extends Factory {

	public SequenceVersion findSequenceVersionBySequenceImplAndNVersion(SequenceImpl firstSequence, int numVersion)
			throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.firstSequence=:firstSequence AND sequenceVersion.numVersion=:numVersion");
		query.setParameter("firstSequence", firstSequence);
		query.setParameter("numVersion", numVersion);

		try {
			SequenceVersion sequenceVersion = (SequenceVersion) query.getSingleResult();
			return sequenceVersion;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SequenceVersion> findSequenceVersionBySequenceImpl(SequenceImpl firstSequence) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.firstSequence=:firstSequence");
		query.setParameter("firstSequence", firstSequence);

		return (List<SequenceVersion>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SequenceVersion> findSequenceVersionByAuteur(Auteur auteur) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.auteur=:auteur");
		query.setParameter("auteur", auteur);

		return (List<SequenceVersion>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {
		return SequenceVersion.class;
	}

}
