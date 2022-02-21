package fr.paquet.ihm.ouvrir;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.paquet.ihm.commun.JPanelButtonAnnulOk;

public class JPanelOpenSequenceButton extends JPanelButtonAnnulOk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelOpenSequenceButton(JPanelOpenSequence jPanelOpenSequence) {
		super(jPanelOpenSequence);
	}

	@Override
	public void setjPanel(JPanel panel) {
		this.panel = panel;

	}

	@Override
	public void setBtnAnnul(JButton btnAnnul) {
		this.btnAnnul = btnAnnul;

	}

	@Override
	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;

	}

}
