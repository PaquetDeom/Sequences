package fr.paquet.ihm.ToolBar;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class ToolBarCopy extends JButtonToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToolBarCopy(SequenceToolBar sequenceToolBar) {
		super(null, sequenceToolBar);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (getSequenceToolBar().getTextPane() != null)
			new Copier(getSequenceToolBar().getTextPane().getSelectedText());

	}

	@Override
	public ImageIcon getIcon() {

		return new ImageIcon("./target/classes/images/icons/copy.png");
	}

}
