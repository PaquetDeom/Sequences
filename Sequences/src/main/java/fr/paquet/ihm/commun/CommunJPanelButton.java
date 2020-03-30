package fr.paquet.ihm.commun;

import java.awt.GridLayout;

import javax.swing.*;



public abstract class CommunJPanelButton extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton button = null;
	private int column = 0;

	protected CommunJPanelButton(String titleButton, int column) throws Exception {
		super();

		// setteur des objet
		setButton(new JButton(titleButton));
		setColumn(column);

		// ajout du layout
		setLayout(new GridLayout(0, column, 0, 0));

		// gestion des contrainte d'affichage
		add(getButton());

		// attribut du panel
	}

	private JButton getButton() {
		return button;
	}

	protected abstract void setButton(JButton button);

	protected int getColumn() {
		return column;
	}

	private void setColumn(int column) {
		this.column = column;
	}

}
