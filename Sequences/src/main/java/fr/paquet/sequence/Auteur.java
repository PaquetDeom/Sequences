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
import javax.persistence.Transient;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;
import fr.paquet.module.ModuleVersion;
import fr.paquet.progression.ProgressionVersion;

@Entity
@Table(name = "AUTEUR")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "PEPEID")),
		@AttributeOverride(name = "nom", column = @Column(name = "PEPENO", length = 20)),
		@AttributeOverride(name = "prenom", column = @Column(name = "PEPEPR", length = 20)) })
public class Auteur extends personne {

	@OneToMany(mappedBy = "auteur", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<SequenceVersion> sequences = null;
	
	@Transient
	private List<ModuleVersion> modules = null;
	
	@Transient
	private List<ProgressionVersion> progressions = null;

	public Auteur() {
		super();
	}

	public Auteur(String nom, String prenom, User user) {
		super(nom, prenom, user);

	}

	public Auteur(String nom, String prenom) {
		super(nom, prenom);

	}

	public List<SequenceVersion> getSequences() {
		if (sequences == null)
			sequences = new ArrayList<SequenceVersion>();
		return sequences;
	}

	public void addSequence(SequenceVersion sequence) {
		getSequences().add(sequence);
	}
	
	public List<ModuleVersion> getModules() {
		if (modules == null)
			modules = new ArrayList<ModuleVersion>();
		return modules;
	}

	public void addModule(ModuleVersion module) {
		getModules().add(module);
	}
	
	public List<ProgressionVersion> getProgressions() {
		if (progressions == null)
			progressions = new ArrayList<ProgressionVersion>();
		return progressions;
	}

	public void addProgression(ProgressionVersion progression) {
		getProgressions().add(progression);
	}

	public String toString() {
		return getNom() + ", " + getPrenom();
	}

}
