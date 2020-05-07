package fr.paquet.ihm.ToolBar;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ToolBarGras extends JButtonToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBarGras(SequenceToolBar sequenceToolBar) {
		super(null, sequenceToolBar);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (getSequenceToolBar().getTextPane() != null) {
			int debutSel = getSequenceToolBar().getTextPane().getSelectionStart();
			int finSel = getSequenceToolBar().getTextPane().getSelectedText().length();

			SimpleAttributeSet centrer = new SimpleAttributeSet();
			StyleConstants.setBold(centrer, true);

			getSequenceToolBar().getStyle().setCharacterAttributes(debutSel, finSel, centrer, false);

		}
	}

	@Override
	public ImageIcon getIcon() {
		
		return new ImageIcon("./target/classes/images/icons/icons8-gras-50.png");
	}

}
