package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import main.Main;

public class ActionQuitter extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionQuitter() {
		super();
		putValue(NAME, getName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Main.Fermeture();
	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Quitter";
	}

	@Override
	protected void Enable() {
		// TODO Auto-generated method stub
		
	}

}
