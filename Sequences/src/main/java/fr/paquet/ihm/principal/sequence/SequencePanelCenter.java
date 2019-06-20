package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelCenterPrérequis sequencePanelCenterPrérequis = null;
	private SequencePanelCenterPrésentation sequencePanelCenterPresentation = null;
	private SequencePanelCenterElements sequencePanelCenterElements = null;
	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	public SequencePanelCenter(SequencePanel sequencePanel) {
		super();

		// set des éléments
		setSequencePanel(sequencePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());
		setSequencePanelCenterPrérequis(new SequencePanelCenterPrérequis("Prérequis Elèves", this));
		setSequencePanelCenterPresentation(
				new SequencePanelCenterPrésentation("Présentation du contexte professionnel", this));
		setSequencePanelCenterElements(new SequencePanelCenterElements("Eléments à retenir", this));
		setSequencePanelCenterLienEval(new SequencePanelCenterLienEval(this));

		// Ajout des composants
		add(getSequencePanelCenterPrérequis(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterPresentation(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterElements(), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterLienEval(), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// Attribut du panel
		setBorder(CommunStyle.BORDER.getBorder());

	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelCenterPrérequis getSequencePanelCenterPrérequis() {
		return sequencePanelCenterPrérequis;
	}

	private void setSequencePanelCenterPrérequis(SequencePanelCenterPrérequis sequencePanelCenterPrérequis) {
		this.sequencePanelCenterPrérequis = sequencePanelCenterPrérequis;
	}

	private SequencePanelCenterPrésentation getSequencePanelCenterPresentation() {
		return sequencePanelCenterPresentation;
	}

	private void setSequencePanelCenterPresentation(SequencePanelCenterPrésentation sequencePanelCenterPresentation) {
		this.sequencePanelCenterPresentation = sequencePanelCenterPresentation;
	}

	private SequencePanelCenterElements getSequencePanelCenterElements() {
		return sequencePanelCenterElements;
	}

	private void setSequencePanelCenterElements(SequencePanelCenterElements sequencePanelCenterElements) {
		this.sequencePanelCenterElements = sequencePanelCenterElements;
	}

	private SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		return sequencePanelCenterLienEval;
	}

	private void setSequencePanelCenterLienEval(SequencePanelCenterLienEval sequencePanelCenterLienEval) {
		this.sequencePanelCenterLienEval = sequencePanelCenterLienEval;
	}

}
