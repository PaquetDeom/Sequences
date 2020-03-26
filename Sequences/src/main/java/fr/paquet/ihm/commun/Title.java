package fr.paquet.ihm.commun;

import java.util.ArrayList;
import java.util.List;

public enum Title {

	COMPETENCES, ACTIVITES;

	public int getcolumn() {
		switch (this) {
		case COMPETENCES:
			return 3;
		case ACTIVITES:
			return 5;
		default:
			return 0;
		}
	}

	public List<String> getTitle() {
		switch (this) {
		case COMPETENCES:
			List<String> values = new ArrayList<String>();
			values.add("Compétences");
			values.add("Indicateurs de performance");
			values.add("Savoirs associés");
			return values;
		case ACTIVITES:
			List<String> value = new ArrayList<String>();
			value.add("Questionnement");
			value.add("Démarche pédagogique");
			value.add("Activités élèves");
			value.add("Ressources - Matériels");
			value.add("Conclusion - Bilan");
			return value;
		default:
			return null;
		}
	}

}
