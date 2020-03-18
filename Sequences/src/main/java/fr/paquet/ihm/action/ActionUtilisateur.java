package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.dataBase.JDialogIdDataBase;

public class ActionUtilisateur extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionUtilisateur() {
		super();
		putValue(NAME, getName());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			new JDialogIdDataBase();
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Erreur lors du chargement de la fenêtre");
			e.printStackTrace();
		}

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	@Override
	public String getName() {

		return "Utilisateur";
	}

}
