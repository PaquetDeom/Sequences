package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Savoir;

public class SavoirFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Savoir.class;
	}

}
