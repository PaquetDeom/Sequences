package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class SequencePanelCenterPrérequis extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequencePanelCenterPrérequis(String title, SequencePanelCenter sequencePanelCenter)
			throws BadLocationException {
		super(null, title, null);

	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, dimensionTextArea.height * 8);

	}

	
	@Override
	protected void setJTextPane(JTextPane jTextPane) {
		this.textPane = jTextPane;

	}

}
