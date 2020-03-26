package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import javax.swing.JPanel;

public class SequencePanelCenterLienEval extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenter sequencePanelCenter = null;

	public SequencePanelCenterLienEval(SequencePanelCenter sequencePanelCenter) {
		super();

		// set des Elements
		setSequencePanelCenter(sequencePanelCenter);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des Composants
		add(getSequencePanelCenterLienEvalLien(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterLienEvalEval(), new GridBagConstraints(1, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	}

	private SequencePanelCenter getSequencePanelCenter() {
		return sequencePanelCenter;
	}

	private void setSequencePanelCenter(SequencePanelCenter sequencePanelCenter) {
		this.sequencePanelCenter = sequencePanelCenter;
	}

	private SequencePanelCenterLienEvalLien sequencePanelCenterLienEvalLien = null;

	private SequencePanelCenterLienEvalLien getSequencePanelCenterLienEvalLien() {
		if (sequencePanelCenterLienEvalLien == null)
			sequencePanelCenterLienEvalLien = new SequencePanelCenterLienEvalLien(this,
					"Liens avec les autres disciplines");
		return sequencePanelCenterLienEvalLien;
	}

	private SequencePanelCenterLienEvalEval sequencePanelCenterLienEvalEval = null;

	private SequencePanelCenterLienEvalEval getSequencePanelCenterLienEvalEval() {
		if (sequencePanelCenterLienEvalEval == null)
			sequencePanelCenterLienEvalEval = new SequencePanelCenterLienEvalEval(this, "Modalités d'évaluation");
		return sequencePanelCenterLienEvalEval;
	}

}
