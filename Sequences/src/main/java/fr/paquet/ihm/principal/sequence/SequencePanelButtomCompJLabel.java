package fr.paquet.ihm.principal.sequence;

import java.awt.GridLayout;

import fr.paquet.ihm.commun.CommunTableauJLabel;

public class SequencePanelButtomCompJLabel extends CommunTableauJLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequencePanelButtomCompJLabel(int columns) {
		super(columns);

		// ajout du layout
		setLayout(new GridLayout(0, columns, 0, 0));

	}

}
