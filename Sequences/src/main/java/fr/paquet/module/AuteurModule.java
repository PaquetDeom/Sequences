package fr.paquet.module;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.commun.personne;
import fr.paquet.dataBase.User;

public class AuteurModule extends personne {

	private List<ModuleVersion> modules = null;

	public AuteurModule() {
		super();
	}

	public AuteurModule(String nom, String prenom, User user) {
		super(nom, prenom, user);
	}

	public AuteurModule(String nom, String prenom) {
		super(nom, prenom);
	}

	public List<ModuleVersion> getModules() {
		if (modules == null)
			modules = new ArrayList<ModuleVersion>();
		return modules;
	}

	public void addSequence(ModuleVersion module) {
		getModules().add(module);
	}

	public String toString() {
		return getNom() + ", " + getPrenom();
	}

}
