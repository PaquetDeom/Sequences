package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Tache;

public class TacheFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Tache.class;
	}

}
