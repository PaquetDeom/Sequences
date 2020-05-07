package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class ActivitePanelConceptionQuestion extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelConception activitePanelConception = null;

	public ActivitePanelConceptionQuestion(ActivitePanelConception activitePanelConception)
			throws BadLocationException {
		super(null, "Questionnement", null);

		// set des compposants
		setActivitePanelConception(activitePanelConception);

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

	@Override
	protected void setJTextPane(JTextPane jTextPane) {
		this.textPane = jTextPane;

	}

}
