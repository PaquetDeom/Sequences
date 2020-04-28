package fr.paquet.ihm.principal.activite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.CommunJPanelButton;
import fr.paquet.ihm.gestionnaire.activite.competence.JDialogCompetenceActivite;
import fr.paquet.sequence.SequenceVersion;
import main.MainOnglet;

public class ActiviteCompButton extends CommunJPanelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs = null;

	public ActiviteCompButton(String titleButton, int column,
			ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		super(titleButton, column);

		// set des composants
		setActivitePanelCompetencesSavoirs(activitePanelCompetencesSavoirs);

	}

	@Override
	protected void setButton(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {

					SequenceVersion sequence = MainOnglet.getUniqInstance().getOngletSequence().getSequenceVersion();
					Activite_1 activite = getActivitePanelCompetencesSavoirs().getActivitePanel().getOngletActivite()
							.getActivite();

					if (sequence.isModifiable(Connect.getPConnexion().getUser().getAuteur())) {
						new JDialogCompetenceActivite(activite,
								getActivitePanelCompetencesSavoirs().getActivitePanel());

					} else {
						new AlertWindow(AlertType.INFORMATION, "La séquence n'est pas modifiable");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

	private ActivitePanelCompetencesSavoirs getActivitePanelCompetencesSavoirs() {
		return activitePanelCompetencesSavoirs;
	}

	private void setActivitePanelCompetencesSavoirs(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		this.activitePanelCompetencesSavoirs = activitePanelCompetencesSavoirs;
	}

}
