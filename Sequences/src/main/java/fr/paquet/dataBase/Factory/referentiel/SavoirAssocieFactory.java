package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.SavoirAssocie;

public class SavoirAssocieFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return SavoirAssocie.class;
	}

}
