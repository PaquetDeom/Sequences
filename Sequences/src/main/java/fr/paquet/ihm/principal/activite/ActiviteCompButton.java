package fr.paquet.ihm.principal.activite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelButton;

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

					getActivitePanelCompetencesSavoirs().addCompetence();

				} catch (Exception e) {
					e.printStackTrace();
				}
				getActivitePanelCompetencesSavoirs().getActiviteJPanelJlabel().affiche();
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
