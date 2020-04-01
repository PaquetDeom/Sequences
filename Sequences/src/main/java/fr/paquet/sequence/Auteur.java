package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;

public class Auteur extends personne {

	private List<Sequence> sequences = null;

	public Auteur(String nom, String prenom, User user) {
		super(nom, prenom, user);

	}

	public Auteur(String nom, String prenom) {
		super(nom, prenom);

	}

	public List<Sequence> getSequences() {
		if (sequences == null)
			sequences = new ArrayList<Sequence>();
		return sequences;
	}

	public void addSequence(Sequence sequence) {
		getSequences().add(sequence);
	}

}
