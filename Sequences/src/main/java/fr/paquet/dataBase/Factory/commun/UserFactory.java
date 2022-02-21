package fr.paquet.dataBase.Factory.commun;

import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.User;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class UserFactory extends Factory {

	public UserFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {

		return User.class;
	}

	public User FindUserByUserName(String utilisateur) throws Exception {

		Query query = Connect.getEm().createQuery("SELECT user FROM User user where user.utilisateur=:utilisateur");
		query.setParameter("utilisateur", utilisateur);

		try {
			return (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

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
