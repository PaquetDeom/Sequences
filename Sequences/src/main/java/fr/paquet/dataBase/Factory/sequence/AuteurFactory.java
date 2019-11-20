package fr.paquet.dataBase.Factory.sequence;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.auteur;

public class AuteurFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return auteur.class;
	}

}
