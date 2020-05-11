package fr.paquet.ihm.principal.activite;

import java.util.List;

import fr.paquet.activite.Ressource;
import fr.paquet.activite.RessourceDocument;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelListJLabelButton;

public class ActivitePanelConceptionDocuments extends JPanelListJLabelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActivitePanelConceptionDocuments(ActivitePanelConception activitePanelConception) {
		super("Documents", activitePanelConception);

	}

	@Override
	protected List<? extends Ressource> getRessources() {

		return getActivite().getDocument();
	}

	@Override
	public void addRessouce(String text, String url) {
		try {
			if (url != null)
				text = "<html><u>" + text + "</u></html>";
			getActivite().AddDocument(new RessourceDocument(text, url, getActivite()));
			affiche();
		} catch (Exception e) {

			new AlertWindow(AlertType.ATTENTION, e.getMessage());
		}

	}

	@Override
	public void removeRessouce(String text, String url) {
		try {
			getActivite().RemoveDocument(new RessourceDocument(text, url, getActivite()));

			affiche();
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}

	}

}
