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
	private SequencePanelEnteteImg sequencePanelEntetImg = null;
	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;

	public SequencePanelEntete(SequencePanel sequencePanel) {

		super();

		// set des elements
		setSequencePanel(sequencePanel);
		setSequencePanelEntetImg(new SequencePanelEnteteImg(this));
		setSequencePanelEntetePbTemps(new SequencePanelEntetePbTemps(this));

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(getSequencePanelEntetImg(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
		add(getSequencePanelEntetePbTemps(), new GridBagConstraints(1, 0, 1, 1, 3, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
		
		//attribut du panel
		
	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelEnteteImg getSequencePanelEntetImg() {
		return sequencePanelEntetImg;
	}

	private void setSequencePanelEntetImg(SequencePanelEnteteImg sequencePanelEntetImg) {
		this.sequencePanelEntetImg = sequencePanelEntetImg;
	}

	private SequencePanelEntetePbTemps getSequencePanelEntetePbTemps() {
		return sequencePanelEntetePbTemps;
	}

	private void setSequencePanelEntetePbTemps(SequencePanelEntetePbTemps sequencePanelEntetePbTemps) {
		this.sequencePanelEntetePbTemps = sequencePanelEntetePbTemps;
	}

}
