package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class ActivitePanelStrategie extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelStrategie(ActivitePanel activitePanel) {
		super("Strategie Pédagogique");

		// set des composants
		setActivitepanel(activitePanel);
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;
	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
	}

	@Override
	protected void setTextArea(JTextArea textArea) {
		this.textArea = textArea;

	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(getPreferredSize().width, getPreferredSize().height * 16);

	}

}
