package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;

public class auteur extends personne {

	private List<Sequence> sequences = null;

	public auteur(String nom, String prenom) {
		super(nom, prenom);

		setNom(nom);
		setPrenom(prenom);
		setType("professeur");
	}

	public List<Sequence> getSequences() {
		if (sequences == null)
			sequences = new ArrayList<Sequence>();
		return sequences;
	}

	public void addSequence(Sequence sequence) {
		getSequences().add(sequence);
	}

	@Override
	protected void setNom(String nom) {
		this.nom = nom;

	}

	@Override
	protected void setPrenom(String prenom) {
		this.prenom = prenom;

	}

	@Override
	protected void setType(String type) {
		this.type = type;

	}

	@Override
	public void setUser(User user) {
		this.user = user;
		
	}

}
