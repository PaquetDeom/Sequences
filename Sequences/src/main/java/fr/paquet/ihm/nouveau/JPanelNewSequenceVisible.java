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
	private JComboBox<String> jComboVisible = null;

	public JPanelNewSequenceVisible(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);

		// ajout du layout
		setLayout(new GridBagLayout());
		setVisibleBox(new JComboBox<String>());

		// Affichege des component
		add(new JLabel("Visibilité :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getVisibleBox(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	private void setVisibleBox(JComboBox<String> jC) {
		jC.addItem("");
		jC.addItem("Que moi");
		jC.addItem("Tout le monde");
		this.jComboVisible = jC;
	}

	public JComboBox<String> getVisibleBox() {

		return jComboVisible;
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

}
