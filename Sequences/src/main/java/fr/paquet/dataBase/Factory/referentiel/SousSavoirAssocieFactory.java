package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.SousSavoirAssocie;

public class SousSavoirAssocieFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return SousSavoirAssocie.class;
	}

}
