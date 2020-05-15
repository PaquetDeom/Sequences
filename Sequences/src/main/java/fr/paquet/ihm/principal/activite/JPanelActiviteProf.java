package fr.paquet.ihm.principal.activite;



import fr.paquet.activite.ActiviteProf;
import fr.paquet.activite.ActiviteStrategie;
import fr.paquet.ihm.commun.JPanelCommunEleveProf;

public class JPanelActiviteProf extends JPanelCommunEleveProf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelActiviteProf(JSplitPaneActProFEleve jSplitPaneActProFEleve) {
		super(jSplitPaneActProFEleve, "Activités professeurs");

	}

	@Override
	protected void addActiviteProfEleve() {
		setActiviteProfEleve(new ActiviteProf());

		getActivite().getStrategie().addActiviteProf((ActiviteProf) getActiviteStrategie());

	}

	@Override
	protected void setActiviteProfEleve(ActiviteStrategie activitePE) {
		this.activiteStrategie = activitePE;

	}

	

}
