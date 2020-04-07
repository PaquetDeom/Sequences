package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;

@Entity
@Table(name = "AUTEUR")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "PEPEID")),
		@AttributeOverride(name = "nom", column = @Column(name = "PEPENO", length = 20)),
		@AttributeOverride(name = "prenom", column = @Column(name = "PEPEPR", length = 20)) })
public class Auteur extends personne {

	@OneToMany(mappedBy = "auteur", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Sequence> sequences = null;

	public Auteur() {
		super();
	}

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

	public String toString() {
		return getNom() + ", " + getPrenom();
	}

}
