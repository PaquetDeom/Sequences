package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Competence;

public class CompetenceFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Competence.class;
	}

}
