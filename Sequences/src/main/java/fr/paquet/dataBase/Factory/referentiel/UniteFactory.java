package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Unite;

public class UniteFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Unite.class;
	}

}