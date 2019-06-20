package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelCenterLienEval extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenter sequencePanelCenter = null;
	private SequencePanelCenterLienEvalLien sequencePanelCenterLienEvalLien = null;
	private SequencePanelCenterLienEvalEval sequencePanelCenterLienEvalEval = null;

	public SequencePanelCenterLienEval(SequencePanelCenter sequencePanelCenter) {
		super();

		// set des Elements
		setSequencePanelCenter(sequencePanelCenter);
		setSequencePanelCenterLienEvalLien(
				new SequencePanelCenterLienEvalLien(this, "Liens avec les autres disciplines"));
		setSequencePanelCenterLienEvalEval(new SequencePanelCenterLienEvalEval(this, "Modalités d'évaluation"));

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

	private SequencePanelCenterLienEvalLien getSequencePanelCenterLienEvalLien() {
		return sequencePanelCenterLienEvalLien;
	}

	private void setSequencePanelCenterLienEvalLien(SequencePanelCenterLienEvalLien sequencePanelCenterLienEvalLien) {
		this.sequencePanelCenterLienEvalLien = sequencePanelCenterLienEvalLien;
	}

	private SequencePanelCenterLienEvalEval getSequencePanelCenterLienEvalEval() {
		return sequencePanelCenterLienEvalEval;
	}

	private void setSequencePanelCenterLienEvalEval(SequencePanelCenterLienEvalEval sequencePanelCenterLienEvalEval) {
		this.sequencePanelCenterLienEvalEval = sequencePanelCenterLienEvalEval;
	}

}
