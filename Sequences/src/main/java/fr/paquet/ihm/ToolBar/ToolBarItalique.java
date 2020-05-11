package fr.paquet.ihm.ToolBar;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ToolBarItalique extends JButtonToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBarItalique(SequenceToolBar sequenceToolBar) {
		super(null, sequenceToolBar);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (getSequenceToolBar().getTextPane() != null) {
			int debutSel = getSequenceToolBar().getTextPane().getSelectionStart();
			int finSel = getSequenceToolBar().getTextPane().getSelectedText().length();

			SimpleAttributeSet centrer = new SimpleAttributeSet();
			StyleConstants.setItalic(centrer, true);

			getSequenceToolBar().getStyle().setCharacterAttributes(debutSel, finSel, centrer, false);

		}
	}

	@Override
	public ImageIcon getIcon() {
		
		return new ImageIcon("./target/classes/images/icons/icons8-italique-48.png");
	}



}
