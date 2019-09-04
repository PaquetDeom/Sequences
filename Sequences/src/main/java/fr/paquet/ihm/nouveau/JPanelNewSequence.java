package fr.paquet.ihm.nouveau;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.principal.sequence.SequencePanelEntete;

public class JPanelNewSequence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogNewSequence jDialogNewSequence = null;
	private JPanelNewSequenceTitle jPanelNewSequenceTitle = null;
	private JPanelNewSequenceReferentiel jPanelNewSequenceReferentiel = null;
	private JPanelNewSequenceVisible jPanelNewSequenceVisible = null;
	private JPanelNewSequenceButton jPanelNewSequenceButton = null;

	public JPanelNewSequence(JDialogNewSequence jDialogNewSequence) {
		super();

		// setteur des éléments
		setjDialogNewSequence(jDialogNewSequence);
		setjPanelNewSequenceTitle(new JPanelNewSequenceTitle(this));
		setjPanelNewSequenceReferentiel(new JPanelNewSequenceReferentiel(this));
		setjPanelNewSequenceVisible(new JPanelNewSequenceVisible(this));
		setjPanelNewSequenceButton(new JPanelNewSequenceButton(this));

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des elements aux panel
		add(getjPanelNewSequenceTitle(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		add(getjPanelNewSequenceReferentiel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 0, 5), 0, 0));
		add(getjPanelNewSequenceVisible(), new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 0, 5), 0, 0));
		add(getjPanelNewSequenceButton(), new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

	}

	public JPanelNewSequenceTitle getjPanelNewSequenceTitle() {
		return jPanelNewSequenceTitle;
	}

	private void setjPanelNewSequenceTitle(JPanelNewSequenceTitle jPanelNewSequenceTitle) {
		this.jPanelNewSequenceTitle = jPanelNewSequenceTitle;
	}

	public JPanelNewSequenceReferentiel getjPanelNewSequenceReferentiel() {
		return jPanelNewSequenceReferentiel;
	}

	private void setjPanelNewSequenceReferentiel(JPanelNewSequenceReferentiel jPanelNewSequenceReferentiel) {
		this.jPanelNewSequenceReferentiel = jPanelNewSequenceReferentiel;
	}

	public JPanelNewSequenceVisible getjPanelNewSequenceVisible() {
		return jPanelNewSequenceVisible;
	}

	private void setjPanelNewSequenceVisible(JPanelNewSequenceVisible jPanelNewSequenceVisible) {
		this.jPanelNewSequenceVisible = jPanelNewSequenceVisible;
	}

	private JPanelNewSequenceButton getjPanelNewSequenceButton() {
		return jPanelNewSequenceButton;
	}

	private void setjPanelNewSequenceButton(JPanelNewSequenceButton jPanelNewSequenceButton) {
		this.jPanelNewSequenceButton = jPanelNewSequenceButton;
	}

	public JDialogNewSequence getjDialogNewSequence() {
		return jDialogNewSequence;
	}

	public void setjDialogNewSequence(JDialogNewSequence jDialogNewSequence) {
		this.jDialogNewSequence = jDialogNewSequence;
	}

}
