package fr.paquet.ihm.principal.activite;

import javax.swing.text.BadLocationException;

import fr.paquet.activite.ActiviteEleve;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelActiviteProfEleve;
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

		try {
			ActiviteEleve aE = new ActiviteEleve(getActivite().getStrategie());
			addjPanelActiviteProfEleves(new JPanelActiviteProfEleve(aE, null, this));
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Création impossible");
		}

	}

	@Override
	protected void initData() {
		if (!getActivite().getStrategie().getActiviteEleves().isEmpty()) {
			for (ActiviteEleve Ae : getActivite().getStrategie().getActiviteEleves()) {
				try {
					JPanelActiviteProfEleve panel = new JPanelActiviteProfEleve(Ae, Ae.getDescription(), this);
					getJPanelActiviteProfEleves().add(panel);
				} catch (BadLocationException e) {
					new AlertWindow(AlertType.ERREUR, "erreur de texte");
				}
			}
		}

	}

}
