package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class JPanelNewSequenceReferentiel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JComboBox<String> listReferentiels = null;

	public JPanelNewSequenceReferentiel(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);
		setListReferentiels(new JComboBox<String>());

		// ajout du Layout
		setLayout(new GridBagLayout());

		// Attribut du panel

		// affichage des components
		add(new JLabel("Référentiel :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getListReferentiels(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	public JComboBox<String> getListReferentiels() {

		return listReferentiels;
	}

	public void setListReferentiels(JComboBox<String> listReferentiels) {
		listReferentiels.addItem("Bac pro tcb");
		listReferentiels.addItem("Cap cb");
		this.listReferentiels = listReferentiels;
	}

}
