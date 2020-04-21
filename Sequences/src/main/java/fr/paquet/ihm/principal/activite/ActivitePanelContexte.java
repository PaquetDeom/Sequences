package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunJLabelJTextAreaVertical;

public class ActivitePanelContexte extends CommunJLabelJTextAreaVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelContexte(ActivitePanel activitePanel) {
		super(null, "Contexte professionnel");

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
		textArea.setLineWrap(true);

	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 10);

	}

}
