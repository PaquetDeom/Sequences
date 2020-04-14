package fr.paquet.ihm.principal.activite;

import fr.paquet.ihm.commun.CommunTitle;
import fr.paquet.ihm.commun.Title;

public class ActiviteCompTitre extends CommunTitle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs = null;

	public ActiviteCompTitre(Title competences, ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs)
			throws Exception {
		super(competences);

		// set des composants
		setActivitePanelCompetencesSavoirs(activitePanelCompetencesSavoirs);

		// attribut du panel

	}

	public ActivitePanelCompetencesSavoirs getActivitePanelCompetencesSavoirs() {
		return activitePanelCompetencesSavoirs;
	}

	private void setActivitePanelCompetencesSavoirs(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		this.activitePanelCompetencesSavoirs = activitePanelCompetencesSavoirs;
	}

}
