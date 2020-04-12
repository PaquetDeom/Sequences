package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;
import fr.paquet.ihm.style.StyleFont;

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

		textArea.setFont(StyleFont.TEXTEAREASEQUENCE.getFont());

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
		textArea.setLineWrap(true);
	}

	private SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		return sequencePanelCenterLienEval;
	}

	private void setSequencePanelCenterLienEval(SequencePanelCenterLienEval sequencePanelCenterLienEval) {
		this.sequencePanelCenterLienEval = sequencePanelCenterLienEval;
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 8);

	}

}
