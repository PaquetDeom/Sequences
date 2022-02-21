package fr.paquet.dataBase.Factory.progression;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.progression.ProgressionImpl;
import fr.paquet.progression.ProgressionVersion;
import fr.paquet.sequence.Auteur;


public class ProgressionVersionFactory extends Factory{
	
	public ProgressionVersion findProgressionVersionByProgressionImplAndNVersion(ProgressionImpl firstProgression, int numVersion)
			throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT ProgressionVersion FROM ProgressionVersion ProgressionVersion WHERE ProgressionVersion.firstProgression=:firstProgression AND ProgressionVersion.numVersion=:numVersion");
		query.setParameter("firstProgression", firstProgression);
		query.setParameter("numVersion", numVersion);

		try {
			ProgressionVersion ProgressionVersion = (ProgressionVersion) query.getSingleResult();
			return ProgressionVersion;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProgressionVersion> findProgressionVersionByProgressionImpl(ProgressionImpl firstProgression) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT ProgressionVersion FROM ProgressionVersion ProgressionVersion WHERE ProgressionVersion.firstProgression=:firstProgression");
		query.setParameter("firstProgression", firstProgression);

		return (List<ProgressionVersion>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ProgressionVersion> findProgressionVersionByAuteur(Auteur auteur) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT ProgressionVersion FROM ProgressionVersion ProgressionVersion WHERE ProgressionVersion.auteur=:auteur");
		query.setParameter("auteur", auteur);

		return (List<ProgressionVersion>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {
		
		return ProgressionVersion.class;
	}

	@Override
	public void removeObject(Object object) {
		// TODO Auto-generated method stub
		
	}

}
