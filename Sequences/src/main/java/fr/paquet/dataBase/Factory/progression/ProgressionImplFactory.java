package fr.paquet.dataBase.Factory.progression;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.progression.ProgressionImpl;
import fr.paquet.referentiel.Referentiel;

public class ProgressionImplFactory extends Factory {

	public ProgressionImpl findProgressionImplByTitle(String title) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT progressionImpl FROM ProgressionImpl progressionImpl WHERE progressionImpl.titre=:title");
		query.setParameter("title", title);

		try {
			ProgressionImpl progImpl = (ProgressionImpl) query.getSingleResult();
			return progImpl;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProgressionImpl> findProgressionImplByReferentiel(Referentiel referentiel) throws Exception {
		Query query = Connect.getEm().createQuery(
				"SELECT progressionImpl FROM ProgressionImpl progressionImpl WHERE progressionImpl.referentiel=:referentiel");
		query.setParameter("referentiel", referentiel);

		return (List<ProgressionImpl>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {

		return ProgressionImpl.class;
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
