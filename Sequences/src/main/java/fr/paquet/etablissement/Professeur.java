package fr.paquet.etablissement;

import java.util.List;

import fr.paquet.sequence.Auteur;

public class Professeur extends Auteur{

	private List<Classe> classes = null;
	
	public Professeur(String name, String firstName) {
		super();
		
		setNom(name);
		setPrenom(firstName);
	}
}
