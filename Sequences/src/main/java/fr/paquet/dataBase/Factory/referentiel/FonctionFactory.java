package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Fonction;

public class FonctionFactory extends Factory {

	@Override
	public Class<?> getClassObject() {
		return Fonction.class;
	}

}