package fr.paquet.ihm.principal.sequence;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class SequencePanelCenterPrérequis extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequencePanelCenterPrérequis(String title, SequencePanelCenter sequencePanelCenter) {
		super(title);
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

}
