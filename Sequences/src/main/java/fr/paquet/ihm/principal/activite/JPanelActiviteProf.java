package fr.paquet.ihm.principal.activite;

import javax.swing.text.BadLocationException;

import fr.paquet.activite.ActiviteProf;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelActiviteProfEleve;
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

		try {
			ActiviteProf aP = new ActiviteProf(getActivite().getStrategie());
			addjPanelActiviteProfEleves(new JPanelActiviteProfEleve(aP, null, this));
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Sauvegarde impossible");
			e.printStackTrace();
		}

	}

	@Override
	protected void initData() {
		if (!getActivite().getStrategie().getActiviteProfs().isEmpty()) {
			for (ActiviteProf Ae : getActivite().getStrategie().getActiviteProfs()) {
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
