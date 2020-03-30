package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class ActivitePanelConceptionQuestion extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelConception activitePanelConception = null;

	public ActivitePanelConceptionQuestion(ActivitePanelConception activitePanelConception) {
		super("Questionnement");

		// set des compposants
		setActivitePanelConception(activitePanelConception);

	}

	@Override
	protected void setTextArea(JTextArea textArea) {
		this.textArea = textArea;

	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		// TODO Auto-generated method stub

	}

	public ActivitePanelConception getActivitePanelConception() {
		return activitePanelConception;
	}

	private void setActivitePanelConception(ActivitePanelConception activitePanelConception) {
		this.activitePanelConception = activitePanelConception;
	}

}
