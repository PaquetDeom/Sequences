package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.Condition;

public class ConditionFactory extends Factory {

	@Override
	public Class<?> getClassObject() {

		return Condition.class;
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
