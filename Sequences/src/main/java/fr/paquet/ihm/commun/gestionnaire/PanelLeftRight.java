package fr.paquet.ihm.commun.gestionnaire;

import java.awt.Dimension;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;
import fr.paquet.ihm.style.StyleFont;

public class PanelLeftRight extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelLeftRight(String text, String title) {
		super(text, title);
	}

	@Override
	protected void setTextArea(JTextArea textArea) {

		textArea.setLineWrap(true);
		textArea.setFont(StyleFont.TITLECORPS.getFont());
		textArea.setEditable(false);

		this.textArea = textArea;
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		// TODO Auto-generated method stub

	}

}
