package fr.paquet.ihm.ouvrir;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import fr.paquet.ihm.nouveau.JPanelNewSequenceReferentiel;

public class JPanelOpenSequence extends JPanel {

	private JDialogOpenSequence jDialogOpenSequence = null;

	public JPanelOpenSequence(JDialogOpenSequence jDialogOpenSequence) {
		super();

		// Layout
		setLayout(new GridBagLayout());

		// set des composants
		setjDialogOpenSequence(jDialogOpenSequence);

		// Ajout des Composants
		add(getjPanelNewSequenceReferentiel(), new GridBagConstraints(0, 0, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("N'ouvrir que mes séquences : "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 10, 5, 0), 0, 0));
		add(getRadioButton(), new GridBagConstraints(1, 1, 1, 1, 0.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(new JPanel(), new GridBagConstraints(2, 1, 1, 1, 1.0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		add(getJPanelOpenSequenceButton(), new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

	}

	private JRadioButton jRadioButton = null;

	public JRadioButton getRadioButton() {
		if (jRadioButton == null)
			jRadioButton = new JRadioButton();
		return jRadioButton;
	}

	private JPanelNewSequenceReferentiel jPanelNewSequenceReferentiel = null;

	public JPanelNewSequenceReferentiel getjPanelNewSequenceReferentiel() {
		if (jPanelNewSequenceReferentiel == null)
			jPanelNewSequenceReferentiel = new JPanelNewSequenceReferentiel(this);
		return jPanelNewSequenceReferentiel;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanelOpenSequenceButton jPanelOpenSequenceButton = null;

	public JPanelOpenSequenceButton getJPanelOpenSequenceButton() {
		if (jPanelOpenSequenceButton == null)
			jPanelOpenSequenceButton = new JPanelOpenSequenceButton(this);
		return jPanelOpenSequenceButton;
	}

	public JDialogOpenSequence getjDialogOpenSequence() {
		return jDialogOpenSequence;
	}

	public void setjDialogOpenSequence(JDialogOpenSequence jDialogOpenSequence) {
		this.jDialogOpenSequence = jDialogOpenSequence;
	}

}
