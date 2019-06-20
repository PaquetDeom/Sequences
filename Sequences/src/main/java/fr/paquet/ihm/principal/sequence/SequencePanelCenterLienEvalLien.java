package fr.paquet.ihm.principal.sequence;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class SequencePanelCenterLienEvalLien extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	public SequencePanelCenterLienEvalLien(SequencePanelCenterLienEval sequencePanelCenterLieneval, String title) {
		super(title);

		// setteur des componenent
		setSequencePanelCenterLienEval(sequencePanelCenterLieneval);
	}

	@Override
	protected void setTextArea(JTextArea textArea) {
		textArea.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		this.textArea = textArea;
	}

	private SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		return sequencePanelCenterLienEval;
	}

	private void setSequencePanelCenterLienEval(SequencePanelCenterLienEval sequencePanelCenterLienEval) {
		this.sequencePanelCenterLienEval = sequencePanelCenterLienEval;
	}

}
