package fr.paquet.dataBase.Factory.referentiel;

import javax.persistence.Query;

import fr.paquet.commun.Diplome;
import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.Referentiel;


public class ReferentielFactory extends Factory {

	/**
	 * 
	 * @param diplome
	 * @return Le referentiel du diplome<br/>
	 * @throws Exception
	 */
	public Referentiel findReferentiel(Diplome diplome) throws Exception {
		Query query = Connect.getEm().createQuery("SELECT ref FROM Referentiel ref where ref.diplome=:diplome");
		query.setParameter("diplome", diplome);
		return (Referentiel) query.getSingleResult();
	}

	@Override
	public Class<?> getClassObject() {
		return Referentiel.class;
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
