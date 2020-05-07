package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class ActivitePanelContexte extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelContexte(ActivitePanel activitePanel) throws BadLocationException {
		super(null, "Contexte professionnel", null);

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
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 10);

	}

	@Override
	protected void setJTextPane(JTextPane jTextPane) {
		this.textPane = jTextPane;

	}

}
