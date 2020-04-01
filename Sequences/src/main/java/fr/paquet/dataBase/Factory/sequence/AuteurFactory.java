package fr.paquet.dataBase.Factory.sequence;

import java.util.List;

import javax.persistence.Query;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.Auteur;

public class AuteurFactory extends Factory {

	@SuppressWarnings("unchecked")
	public List<Auteur> findListAuteurByName(String name) throws Exception{

		Query query = getConnect().getEm().createQuery("SELECT auteur FROM Auteur auteur where auteur.nom like :name");

		query.setParameter("name", "%" + name + "%");

		@SuppressWarnings("unchecked")
		List<Auteur> l = query.getResultList();

		return l;
	}

	@Override
	public Class<?> getClassObject() {

		return Auteur.class;
	}

}
