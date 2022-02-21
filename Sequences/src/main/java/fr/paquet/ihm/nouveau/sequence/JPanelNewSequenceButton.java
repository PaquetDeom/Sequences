package fr.paquet.ihm.nouveau.sequence;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.JPanelButtonAnnulOk;

import javax.swing.JButton;

public class JPanelNewSequenceButton extends JPanelButtonAnnulOk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelNewSequenceButton(JPanelNewSequence jPanelNewSequence) {
		super(jPanelNewSequence);

	}

	public JPanelNewSequenceButton(JPanelNewVersion jPanelNewVersion) {
		super(jPanelNewVersion);

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
