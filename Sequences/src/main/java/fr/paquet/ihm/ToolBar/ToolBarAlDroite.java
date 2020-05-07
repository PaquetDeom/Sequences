package fr.paquet.ihm.ToolBar;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ToolBarAlDroite extends JButtonToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBarAlDroite(SequenceToolBar sequenceToolBar) {
		super(null, sequenceToolBar);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (getSequenceToolBar().getTextPane() != null) {
			int debutSel = getSequenceToolBar().getTextPane().getSelectionStart();
			int finSel = getSequenceToolBar().getTextPane().getSelectedText().length();

			SimpleAttributeSet centrer = new SimpleAttributeSet();
			StyleConstants.setAlignment(centrer, StyleConstants.ALIGN_RIGHT);

			getSequenceToolBar().getStyle().setParagraphAttributes(debutSel, finSel, centrer, false);
		}
	}

	@Override
	public ImageIcon getIcon() {

		return new ImageIcon("./target/classes/images/icons/icons8-alignement-à-droite-50.png");
	}

}
