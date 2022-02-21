package fr.paquet.ihm.principal.activite;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JTableCompetences;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;

public class ActiviteCompCompSavoir extends JTableCompetences implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs = null;

	public ActiviteCompCompSavoir(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs)
			throws BadLocationException {
		this(null, null, activitePanelCompetencesSavoirs);

	}

	public ActiviteCompCompSavoir(List<CompetenceIntermediaire> competenceIntermediaires,
			List<SavoirAssocie> savoirAssocies, ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs)
			throws BadLocationException {
		super(competenceIntermediaires, savoirAssocies);

		// set des composants
		setActivitePanelCompetencesSavoirs(activitePanelCompetencesSavoirs);

		// listener
		getActivitePanelCompetencesSavoirs().getActivitePanel().getOngletActivite().getActivite()
				.addPropertyChangeListener(this);
	}

	public ActivitePanelCompetencesSavoirs getActivitePanelCompetencesSavoirs() {
		return activitePanelCompetencesSavoirs;
	}

	private void setActivitePanelCompetencesSavoirs(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		this.activitePanelCompetencesSavoirs = activitePanelCompetencesSavoirs;
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		try {
			affiche();
		} catch (BadLocationException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, "Affichage imposible");
		}

	}

}
