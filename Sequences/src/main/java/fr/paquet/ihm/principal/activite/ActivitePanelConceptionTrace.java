package fr.paquet.ihm.principal.activite;

import java.util.List;

import fr.paquet.activite.Ressource;
import fr.paquet.activite.RessourceTrace;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelListJLabelButton;

public class ActivitePanelConceptionTrace extends JPanelListJLabelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActivitePanelConceptionTrace(ActivitePanelConception activitePanelConception) {
		super("Trace écrite", activitePanelConception);

	}

	@Override
	protected List<? extends Ressource> getRessources() {

		return getActivite().getTrace();
	}

	@Override
	public void addRessouce(String text, String url) {
		try {
			if (url != null)
				text = "<html><u>" + text + "</u></html>";
			getActivite().AddTrace(new RessourceTrace(text, url, getActivite()));
			affiche();
		} catch (Exception e) {

			new AlertWindow(AlertType.ATTENTION, e.getMessage());
		}

	}

	@Override
	public void removeRessouce(String text, String url) {
		try {
			getActivite().RemoveTrace(new RessourceTrace(text, url, getActivite()));

			affiche();
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}
	}

}
