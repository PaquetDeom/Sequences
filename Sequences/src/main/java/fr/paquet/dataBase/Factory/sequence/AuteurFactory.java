package fr.paquet.dataBase.Factory.sequence;

import java.util.List;

import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.User;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.Auteur;


public class AuteurFactory extends Factory {

	@SuppressWarnings("unchecked")
	public List<Auteur> findListAuteurByName(String name) throws Exception {

		Query query = Connect.getEm().createQuery("SELECT auteur FROM Auteur auteur where auteur.nom like :name");

		query.setParameter("name", "%" + name + "%");

		List<Auteur> l = query.getResultList();

		return l;
	}

	public Auteur FindAuteurByUser(User user) throws Exception {
		Query query = Connect.getEm().createQuery("SELECT auteur From Auteur auteur where auteur.user:=user");
		query.setParameter("user", user);

		return (Auteur) query.getSingleResult();
	}

	@Override
	public Class<?> getClassObject() {

		return Auteur.class;
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
