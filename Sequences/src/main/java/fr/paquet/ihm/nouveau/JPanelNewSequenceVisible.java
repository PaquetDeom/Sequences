package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;

import java.awt.Insets;

public class JPanelNewSequenceVisible extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;

	public JPanelNewSequenceVisible(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);

		// ajout du layout
		setLayout(new GridBagLayout());

		// Affichege des component
		add(new JLabel("Visibilité :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getVisibleBox(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	private JComboBox<String> getVisibleBox() {
		JComboBox<String> visible = new JComboBox<String>();
		visible.addItem("Que moi");
		visible.addItem("Tout le monde");
		return visible;
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

}
