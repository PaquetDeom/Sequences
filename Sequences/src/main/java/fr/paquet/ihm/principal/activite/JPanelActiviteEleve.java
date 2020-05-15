package fr.paquet.ihm.principal.activite;

import fr.paquet.activite.ActiviteEleve;
import fr.paquet.activite.ActiviteStrategie;
import fr.paquet.ihm.commun.JPanelCommunEleveProf;

public class JPanelActiviteEleve extends JPanelCommunEleveProf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelActiviteEleve(JSplitPaneActProFEleve jSplitPaneActProFEleve) {
		super(jSplitPaneActProFEleve, "Activités élèves");

	}

	@Override
	protected void addActiviteProfEleve() {
		setActiviteProfEleve(new ActiviteEleve());
		getActiviteStrategie().addPropertyChangeListener(
				getjSplitPaneActProFEleve().getActivitePanelStrategie().getPanelStrtegieDemarche());
		getActivite().getStrategie().addActiviteEleve((ActiviteEleve) getActiviteStrategie());

	}

	@Override
	protected void setActiviteProfEleve(ActiviteStrategie activitePE) {
		this.activiteStrategie = activitePE;

	}

}
