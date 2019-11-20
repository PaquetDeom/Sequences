package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Rap;

public class RapFactory extends Factory {

	public RapFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {
		return Rap.class;
	}
}
