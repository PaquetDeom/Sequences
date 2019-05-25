package fr.paquet.ihm.principal.sequence;

import javax.swing.JPanel;

public class SequencePanelButtom extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelButtom(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);

		// Ajout du Layout

	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

}
