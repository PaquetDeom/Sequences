package fr.paquet.ihm.commun.gestionnaire;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleFont;

public class PanelLeftRight extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelLeftRight(String text, String title, SimpleAttributeSet simpleAttribiteSet) throws BadLocationException {
		super(text, title, simpleAttribiteSet);
	}

	@Override
	protected void setJTextPane(JTextPane jTextPane) {

		jTextPane.setFont(StyleFont.TITLECORPS.getFont());
		jTextPane.setEditable(false);

		this.textPane = jTextPane;
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {

	}

}
