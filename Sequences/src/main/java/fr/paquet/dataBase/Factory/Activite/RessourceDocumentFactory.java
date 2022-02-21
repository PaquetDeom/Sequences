package fr.paquet.dataBase.Factory.Activite;

import fr.paquet.activite.RessourceDocument;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class RessourceDocumentFactory extends Factory {

	@Override
	public Class<?> getClassObject() {
		
		return RessourceDocument.class;
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
