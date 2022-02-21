package fr.paquet.progression;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;

public class AuteurProgression extends personne {
	
	private List<ProgressionVersion> progressions = null;
	
	public AuteurProgression() {
		super();
	}
	
	public AuteurProgression(String nom, String prenom, User user) {
		super(nom, prenom, user);
	}
	
	public AuteurProgression(String nom, String prenom) {
		super(nom, prenom);
	}
	
	public List<ProgressionVersion> getProgressions() {
		if (progressions == null)
			progressions = new ArrayList<ProgressionVersion>();
		return progressions;
	}

	public void addSequence(ProgressionVersion progression) {
		getProgressions().add(progression);
	}

	public String toString() {
		return getNom() + ", " + getPrenom();
	}

}
