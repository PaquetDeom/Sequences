package fr.paquet.dataBase;

public class User {

	private String utilisateur = null;
	private String pass = null;

	public User(String utilisateur, String pass) throws Exception {
		super();
		setUtilisateur(utilisateur);
		setPass(pass);
	}

	public String getUtilisateur() {
		return utilisateur;
	}

	private void setUtilisateur(String utilisateur) throws Exception {
		if (utilisateur == null || utilisateur.equals(""))
			throw new Exception("Veuillez saisir un nom d'utilisateur");
		this.utilisateur = utilisateur;
	}

	public String getPass() {

		return pass;
	}

	private void setPass(String pass) throws Exception {
		if (pass == null || pass.equals(""))
			throw new Exception("Veuillez saisir un mot de passe");
		this.pass = pass;
	}
}
