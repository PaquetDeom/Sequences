package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class SequencePanelEntetePbTempsProblématique extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;

	public SequencePanelEntetePbTempsProblématique(SequencePanelEntetePbTemps sequencePanelEntetePbTemps, String title)
			throws BadLocationException {
		super(null, title, null);

		// setteur
		setSequencePanelEntetePbTemps(sequencePanelEntetePbTemps);

	}

	public SequencePanelEntetePbTemps getSequencePanelEntetePbTemps() {
		return sequencePanelEntetePbTemps;
	}

	public void setSequencePanelEntetePbTemps(SequencePanelEntetePbTemps sequencePanelEntetePbTemps) {
		this.sequencePanelEntetePbTemps = sequencePanelEntetePbTemps;
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 8);

	}

	
	@Override
	protected void setJTextPane(JTextPane jTextPane) {
		this.textPane = jTextPane;
		
	}

}
