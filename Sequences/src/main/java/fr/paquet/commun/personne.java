package fr.paquet.commun;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import fr.paquet.dataBase.User;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class personne {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id = 0;

	@Column(name = "PEPENO", length = 20)
	private String nom = null;

	@Column(name = "PEPEPR", length = 20)
	private String prenom = null;

	public personne(String nom, String prenom, User user) {
		this(nom, prenom);

		addUser(user);

	}

	public personne() {
		super();
	}

	public personne(String nom, String prenom) {
		super();

		setNom(nom);
		setPrenom(prenom);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom.trim().toLowerCase();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom.trim().toLowerCase();
	}

	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
