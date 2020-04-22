package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

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
		// TODO

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
