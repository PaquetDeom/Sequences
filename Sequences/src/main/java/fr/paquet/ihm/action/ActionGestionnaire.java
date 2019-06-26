package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.ouvrir.Gestionnaire;

public class ActionGestionnaire extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionGestionnaire() {
		super();
		putValue(NAME, getName());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Gestionnaire();

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	@Override
	public String getName() {

		return "Gestionnaire de sequences";
	}

}
