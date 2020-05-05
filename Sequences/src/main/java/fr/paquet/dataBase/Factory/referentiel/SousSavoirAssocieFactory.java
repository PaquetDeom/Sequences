package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.SousSavoirAssocie;

public class SousSavoirAssocieFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return SousSavoirAssocie.class;
	}

	@Override
	public void removeObject(Object object) {
		try {
			remove(object);
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Connexion à la base Impossible");
			e.printStackTrace();
		}

	}

}
