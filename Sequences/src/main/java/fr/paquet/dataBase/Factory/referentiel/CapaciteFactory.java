package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Capacite;

public class CapaciteFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Capacite.class;
	}

}
