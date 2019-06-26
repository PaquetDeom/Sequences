package fr.paquet.ihm.principal.sequence;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;
import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelEntetePbTempsProblématique extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;

	public SequencePanelEntetePbTempsProblématique(SequencePanelEntetePbTemps sequencePanelEntetePbTemps,
			String title) {
		super(title);

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
	protected void setTextArea(JTextArea textArea) {

		textArea.setFont(CommunStyle.TEXTAREASEQUENCE.getFont());

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

}
