package fr.paquet.ihm.nouveau.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;

public class JPanelNewSequence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogNewSequence jDialogNewSequence = null;

	public JPanelNewSequence(JDialogNewSequence jDialogNewSequence) {
		super();

		// setteur des éléments
		setjDialogNewSequence(jDialogNewSequence);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des elements aux panel
		add(getjPanelNewSequenceTitle(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getjPanelNewSequenceReferentiel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getjPanelNewSequenceClasse(), new GridBagConstraints(0, 2, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getjPanelNewSequenceButton(), new GridBagConstraints(0, 3, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		// atributs du Panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private JPanelNewSequenceClasse jPanelNewSequenceClasse = null;

	public JPanelNewSequenceClasse getjPanelNewSequenceClasse() {
		if (jPanelNewSequenceClasse == null)
			jPanelNewSequenceClasse = new JPanelNewSequenceClasse(this);
		return jPanelNewSequenceClasse;
	}

	private JPanelNewSequenceTitle jPanelNewSequenceTitle = null;

	public JPanelNewSequenceTitle getjPanelNewSequenceTitle() {
		if (jPanelNewSequenceTitle == null)
			jPanelNewSequenceTitle = new JPanelNewSequenceTitle(this);
		return jPanelNewSequenceTitle;
	}

	private JPanelNewSequenceReferentiel jPanelNewSequenceReferentiel = null;

	public JPanelNewSequenceReferentiel getjPanelNewSequenceReferentiel() {
		if (jPanelNewSequenceReferentiel == null)
			jPanelNewSequenceReferentiel = new JPanelNewSequenceReferentiel(this);
		return jPanelNewSequenceReferentiel;
	}

	private JPanelNewSequenceButton jPanelNewSequenceButton = null;

	public JPanelNewSequenceButton getjPanelNewSequenceButton() {
		if (jPanelNewSequenceButton == null)
			jPanelNewSequenceButton = new JPanelNewSequenceButton(this);
		return jPanelNewSequenceButton;
	}

	public JDialogNewSequence getjDialogNewSequence() {
		return jDialogNewSequence;
	}

	public void setjDialogNewSequence(JDialogNewSequence jDialogNewSequence) {
		this.jDialogNewSequence = jDialogNewSequence;
	}

}
