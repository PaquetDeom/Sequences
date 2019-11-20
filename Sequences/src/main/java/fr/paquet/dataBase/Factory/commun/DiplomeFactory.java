package fr.paquet.dataBase.Factory.commun;

import javax.persistence.Query;

import fr.paquet.commun.Diplome;

public class DiplomeFactory extends Factory {

	/**
	 * 
	 * @param diplome
	 * @param type
	 * @return un diplome donne<br/>
	 */
	public Diplome findDiplome(String diplome, String type) {
		Query query = getEm().createQuery("SELECT dip FROM Diplome dip where dip.diplome=:diplome and dip.type=:type");
		query.setParameter("diplome", diplome);
		query.setParameter("type", type);
		return (Diplome) query.getSingleResult();
	}

	@Override
	public Class<?> getClassObject() {
		return Diplome.class;
	}
}
