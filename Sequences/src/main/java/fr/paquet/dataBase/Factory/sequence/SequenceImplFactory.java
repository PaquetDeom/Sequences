package fr.paquet.dataBase.Factory.sequence;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.Referentiel;
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

	@SuppressWarnings("unchecked")
	public List<SequenceImpl> findSequenceImplByReferentiel(Referentiel referentiel) throws Exception {
		Query query = Connect.getEm().createQuery(
				"SELECT sequenceImpl FROM SequenceImpl sequenceImpl WHERE sequenceImpl.referentiel=:referentiel");
		query.setParameter("referentiel", referentiel);

		return (List<SequenceImpl>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {

		return SequenceImpl.class;
	}

	@Override
	public void removeObject(Object object) {
		try {
			remove(object);
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Connexion à la base Impossible");
			e.printStackTrace();
		}

	}

}
