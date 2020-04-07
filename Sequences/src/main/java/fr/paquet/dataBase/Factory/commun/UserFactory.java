package fr.paquet.dataBase.Factory.commun;

import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.User;
import main.Main;

public class UserFactory extends Factory {

	public UserFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {

		return User.class;
	}

	public User FindUserByUserName(String utilisateur) throws Exception {

		Query query = Connect.getEm()
				.createQuery("SELECT user FROM User user where user.utilisateur=:utilisateur");
		query.setParameter("utilisateur", utilisateur);

		return (User) query.getSingleResult();

	}

}