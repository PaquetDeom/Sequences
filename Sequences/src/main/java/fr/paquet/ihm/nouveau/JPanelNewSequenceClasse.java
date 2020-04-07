package fr.paquet.ihm.nouveau;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;

public class JPanelNewSequenceClasse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;

	public JPanelNewSequenceClasse(JPanelNewSequence jPanelNewSequence) {
		super();

		// set des composants
		setjPanelNewSequence(jPanelNewSequence);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des éléments :
		add(new JLabel("Classe concernée :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getComboBox(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

	}

	private JComboBox<String> getComboBox() {
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Seconde bac");
		comboBox.addItem("Première bac");
		comboBox.addItem("Terminale bac");
		return comboBox;
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

}
