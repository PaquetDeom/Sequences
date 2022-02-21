package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ActivitePanelCorps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	public ActivitePanelCorps(ActivitePanel activitePanel) {
		super();

		// set des composants
		setActivitePanel(activitePanel);

		// Création du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(getActivitePanelCorpsGauche(), new GridBagConstraints(0, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getActivitePanelCorpsDroite(), new GridBagConstraints(1, 0, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

	}

	private ActivitePanelCorpsDroite activitePanelCorpsDroite = null;

	private ActivitePanelCorpsDroite getActivitePanelCorpsDroite() {
		if (activitePanelCorpsDroite == null)
			activitePanelCorpsDroite = new ActivitePanelCorpsDroite(this);
		return activitePanelCorpsDroite;
	}

	private ActivitePanelCorpsGauche activitePanelCorpsGauche = null;

	private ActivitePanelCorpsGauche getActivitePanelCorpsGauche() {
		if (activitePanelCorpsGauche == null)
			activitePanelCorpsGauche = new ActivitePanelCorpsGauche(this);
		return activitePanelCorpsGauche;
	}

	public ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

}
