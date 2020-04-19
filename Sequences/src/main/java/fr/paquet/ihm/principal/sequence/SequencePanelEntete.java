package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class SequencePanelEntete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelEntete(SequencePanel sequencePanel) {

		super();

		// set des elements
		setSequencePanel(sequencePanel);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(getSequencePanelEntetImg(), new GridBagConstraints(0, 0, 1, 1, 0.3, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
		add(getSequencePanelEntetePbTemps(), new GridBagConstraints(1, 0, 1, 1, 0.7, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelEnteteImg sequencePanelEntetImg = null;

	private SequencePanelEnteteImg getSequencePanelEntetImg() {
		if (sequencePanelEntetImg == null)
			sequencePanelEntetImg = new SequencePanelEnteteImg(null, this);
		return sequencePanelEntetImg;
	}

	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;

	private SequencePanelEntetePbTemps getSequencePanelEntetePbTemps() {
		if (sequencePanelEntetePbTemps == null)
			sequencePanelEntetePbTemps = new SequencePanelEntetePbTemps(this);
		return sequencePanelEntetePbTemps;
	}
}
