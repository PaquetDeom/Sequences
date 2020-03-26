package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelCenter(SequencePanel sequencePanel) throws Exception {
		super();

		// set des éléments
		setSequencePanel(sequencePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(getSequencePanelCenterPrérequis(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterPresentation(), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterElements(), new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterLienEval(), new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelCenterPrérequis sequencePanelCenterPrérequis = null;

	private SequencePanelCenterPrérequis getSequencePanelCenterPrérequis() {
		if (sequencePanelCenterPrérequis == null)
			sequencePanelCenterPrérequis = new SequencePanelCenterPrérequis("Prérequis Elèves", this);
		return sequencePanelCenterPrérequis;
	}

	private SequencePanelCenterPrésentation sequencePanelCenterPresentation = null;

	private SequencePanelCenterPrésentation getSequencePanelCenterPresentation() {
		if (sequencePanelCenterPresentation == null)
			sequencePanelCenterPresentation = new SequencePanelCenterPrésentation(
					"Présentation du contexte professionnel", this);
		return sequencePanelCenterPresentation;
	}

	private SequencePanelCenterElements sequencePanelCenterElements = null;

	private SequencePanelCenterElements getSequencePanelCenterElements() {
		if (sequencePanelCenterElements == null)
			sequencePanelCenterElements = new SequencePanelCenterElements("Eléments à retenir", this);
		return sequencePanelCenterElements;
	}

	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	private SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		if (sequencePanelCenterLienEval == null)
			sequencePanelCenterLienEval = new SequencePanelCenterLienEval(this);
		return sequencePanelCenterLienEval;
	}

}
