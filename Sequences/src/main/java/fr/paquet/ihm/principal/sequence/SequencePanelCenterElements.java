package fr.paquet.ihm.principal.sequence;


import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;
import fr.paquet.ihm.style.StyleFont;

public class SequencePanelCenterElements extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequencePanelCenterElements(String title, SequencePanelCenter sequencePanelCenter) {
		super(title);

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
	}

}
