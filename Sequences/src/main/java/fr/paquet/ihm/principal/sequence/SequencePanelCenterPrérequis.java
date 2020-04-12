package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;
import fr.paquet.ihm.style.StyleFont;

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

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, dimensionTextArea.height * 8);

	}

}
