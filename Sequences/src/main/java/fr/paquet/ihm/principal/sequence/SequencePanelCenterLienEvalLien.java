package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class SequencePanelCenterLienEvalLien extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	public SequencePanelCenterLienEvalLien(SequencePanelCenterLienEval sequencePanelCenterLieneval, String title)
			throws BadLocationException {
		super(null, title, null);

		// setteur des componenent
		setSequencePanelCenterLienEval(sequencePanelCenterLieneval);
	}

	public SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		return sequencePanelCenterLienEval;
	}

	private void setSequencePanelCenterLienEval(SequencePanelCenterLienEval sequencePanelCenterLienEval) {
		this.sequencePanelCenterLienEval = sequencePanelCenterLienEval;
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 8);

	}

	
	@Override
	protected void setJTextPane(JTextPane jTextPane) {
		this.textPane=jTextPane;
		
	}

}
