package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;

public class ActivitePanelConceptionRessources extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelConception activitePanelConception = null;

	public ActivitePanelConceptionRessources(ActivitePanelConception activitePanelConception)
			throws BadLocationException {
		super(null, "Ressouces / Conditions", null);

		// set des composants
		setActivitePanelConception(activitePanelConception);
	}

	@Override
	protected void setPanelJTextAreaTextSize(Dimension dimensionTextArea) {
		this.dimensionTextArea = new Dimension(0, getPreferredSize().height * 10);

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
