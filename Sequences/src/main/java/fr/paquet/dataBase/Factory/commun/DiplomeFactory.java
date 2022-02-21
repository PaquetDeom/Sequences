package fr.paquet.dataBase.Factory.commun;

import javax.persistence.Query;

import fr.paquet.commun.Diplome;
import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class DiplomeFactory extends Factory {

	/**
	 * 
	 * @param diplome
	 * @param type
	 * @return un diplome donne<br/>
	 * @throws Exception
	 */
	public Diplome findDiplome(String diplome, String type) throws Exception {
		Query query = Connect.getEm()
				.createQuery("SELECT dip FROM Diplome dip where dip.diplome=:diplome and dip.type=:type");
		query.setParameter("diplome", diplome);
		query.setParameter("type", type);
		return (Diplome) query.getSingleResult();
	}

	@Override
	public Class<?> getClassObject() {
		return Diplome.class;
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
