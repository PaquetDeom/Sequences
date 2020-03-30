package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ActivitePanelConception extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelConception(ActivitePanel activitePanel) {
		super();

		// set des composants
		setActivitepanel(activitePanel);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// attribut du panel

		// ajout des Composants
		add(getActivitePanelConceptionQuestion(), new GridBagConstraints(0, 0, 1, 2, 0.5, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActivitePanelConceptionDocuments(), new GridBagConstraints(1, 0, 1, 1, 0.5, 0.5,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActivitePanelConceptionRessources(), new GridBagConstraints(1, 1, 1, 1, 0, 0.5,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	private ActivitePanelConceptionRessources activitePanelConceptionRessources = null;

	private ActivitePanelConceptionRessources getActivitePanelConceptionRessources() {
		if (activitePanelConceptionRessources == null)
			activitePanelConceptionRessources = new ActivitePanelConceptionRessources(this);
		return activitePanelConceptionRessources;
	}

	private ActivitePanelConceptionDocuments activitePanelConceptionDocuments = null;

	private ActivitePanelConceptionDocuments getActivitePanelConceptionDocuments() {
		if (activitePanelConceptionDocuments == null)
			activitePanelConceptionDocuments = new ActivitePanelConceptionDocuments(this);
		return activitePanelConceptionDocuments;
	}

	private ActivitePanelConceptionQuestion activitePanelConceptionQuestion = null;

	private ActivitePanelConceptionQuestion getActivitePanelConceptionQuestion() {
		if (activitePanelConceptionQuestion == null)
			activitePanelConceptionQuestion = new ActivitePanelConceptionQuestion(this);
		return activitePanelConceptionQuestion;
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;
	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
	}

}
