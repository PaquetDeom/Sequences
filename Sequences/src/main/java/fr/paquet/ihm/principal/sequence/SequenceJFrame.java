package fr.paquet.ihm.principal.sequence;

import javax.swing.*;

import fr.paquet.sequence.Sequence;

public class SequenceJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Sequence sequence = null;

	public SequenceJFrame(Sequence sequence) {
		
		super();
		setSequence(sequence);
		
		
	}

	public Sequence getSequence() {
		return sequence;
	}

	private void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
}
