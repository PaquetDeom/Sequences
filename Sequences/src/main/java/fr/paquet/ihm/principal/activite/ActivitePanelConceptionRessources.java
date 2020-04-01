package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class ActivitePanelConceptionRessources extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelConception activitePanelConception = null;

	public ActivitePanelConceptionRessources(ActivitePanelConception activitePanelConception) {
		super("Ressouces / Conditions");

		// set des composants
		setActivitePanelConception(activitePanelConception);
	}

	@Override
	protected void setTextArea(JTextArea textArea) {
		this.textArea = textArea;

	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(getPreferredSize().width, getPreferredSize().height * 10);

	}

	public ActivitePanelConception getActivitePanelConception() {
		return activitePanelConception;
	}

	private void setActivitePanelConception(ActivitePanelConception activitePanelConception) {
		this.activitePanelConception = activitePanelConception;
	}

}
