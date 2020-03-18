package fr.paquet.commun;

import fr.paquet.dataBase.User;

public abstract class personne {

	protected String nom = null;
	protected String prenom = null;
	protected String type = null;
	protected User user = null;

	public personne(String nom, String prenom) {
		super();

	}

	public String getNom() {
		return nom;
	}

	protected abstract void setNom(String nom);

	public String getPrenom() {
		return prenom;
	}

	protected abstract void setPrenom(String prenom);

	public String getType() {
		return type;
	}

	protected abstract void setType(String type);

	public User getUser() {
		return user;
	}

	public abstract void setUser(User user);
}
