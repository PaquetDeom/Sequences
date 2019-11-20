package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Activite;

public class ActiviteFactory extends Factory {

	public ActiviteFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {
		return Activite.class;
	}

}
