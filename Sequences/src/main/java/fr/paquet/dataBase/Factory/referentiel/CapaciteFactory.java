package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Capacite;

public class CapaciteFactory extends Factory {

	public CapaciteFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {
		
		return Capacite.class;
	}

}
