package fr.paquet.commun;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.dataBase.User;

public class personne {

	private String nom = null;
	private String prenom = null;

	public personne(String nom, String prenom, User user) {
		this(nom, prenom);

		addUser(user);

	}

	public personne(String nom, String prenom) {
		super();

		setNom(nom);
		setPrenom(prenom);
	}

	public String getNom() {
		return nom;
	}

	private void setNom(String nom) {
		this.nom = nom.trim().toLowerCase();
	}

	public String getPrenom() {
		return prenom;
	}

	protected void setPrenom(String prenom) {
		this.prenom = prenom.trim().toLowerCase();
	}

	protected List<User> users = null;

	public List<User> getUsers() {
		if (users == null)
			users = new ArrayList<User>();
		return users;
	}

	public void addUser(User user) {
		getUsers().add(user);
	}
}
