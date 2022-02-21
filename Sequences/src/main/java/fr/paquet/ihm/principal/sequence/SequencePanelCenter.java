package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public class SequencePanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelCenter(SequencePanel sequencePanel) throws BadLocationException {
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

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelCenterPrérequis sequencePanelCenterPrérequis = null;

	private SequencePanelCenterPrérequis getSequencePanelCenterPrérequis() throws BadLocationException {
		if (sequencePanelCenterPrérequis == null) {
			if (MainFrame.getUniqInstance().getSequenceVersion().getPrerequis() == null)
				sequencePanelCenterPrérequis = new SequencePanelCenterPrérequis(this);
			else
				sequencePanelCenterPrérequis = new SequencePanelCenterPrérequis(
						MainFrame.getUniqInstance().getSequenceVersion().getPrerequis(), this);
		}

		return sequencePanelCenterPrérequis;
	}

	private SequencePanelCenterPrésentation sequencePanelCenterPresentation = null;

	private SequencePanelCenterPrésentation getSequencePanelCenterPresentation() throws BadLocationException {
		if (sequencePanelCenterPresentation == null) {
			if (MainFrame.getUniqInstance().getSequenceVersion().getContexte() == null)
				sequencePanelCenterPresentation = new SequencePanelCenterPrésentation(this);
			else
				sequencePanelCenterPresentation = new SequencePanelCenterPrésentation(
						MainFrame.getUniqInstance().getSequenceVersion().getContexte(), this);
		}

		return sequencePanelCenterPresentation;
	}

	private SequencePanelCenterElements sequencePanelCenterElements = null;

	private SequencePanelCenterElements getSequencePanelCenterElements() throws BadLocationException {
		if (sequencePanelCenterElements == null) {
			if (MainFrame.getUniqInstance().getSequenceVersion().getElementsARetenir() == null)
				sequencePanelCenterElements = new SequencePanelCenterElements(this);
			else
				sequencePanelCenterElements = new SequencePanelCenterElements(
						MainFrame.getUniqInstance().getSequenceVersion().getElementsARetenir(), this);
		}
		return sequencePanelCenterElements;
	}

	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	private SequencePanelCenterLienEval getSequencePanelCenterLienEval() throws BadLocationException {
		if (sequencePanelCenterLienEval == null)
			sequencePanelCenterLienEval = new SequencePanelCenterLienEval(this);
		return sequencePanelCenterLienEval;
	}

}
