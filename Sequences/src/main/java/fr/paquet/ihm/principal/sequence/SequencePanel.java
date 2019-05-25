package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class SequencePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceJFrame sequenceJFrame = null;

	public SequencePanel(SequenceJFrame sequenceJFrame) {
		super();

		// set des composants
		setSequenceJFrame(sequenceJFrame);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(new SequencePanelEntete(this), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new SequencePanelCenter(this), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new SequencePanelButtom(this), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	}

	private SequenceJFrame getSequenceJFrame() {
		return sequenceJFrame;
	}

	private void setSequenceJFrame(SequenceJFrame sequenceJFrame) {
		this.sequenceJFrame = sequenceJFrame;
	}

}
