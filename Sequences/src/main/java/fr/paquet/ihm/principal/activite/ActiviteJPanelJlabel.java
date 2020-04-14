package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class ActiviteJPanelJlabel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs = null;

	public ActiviteJPanelJlabel(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		super();

		// set des composants
		setActivitePanelCompetencesSavoirs(activitePanelCompetencesSavoirs);

		// creation du Layout
		setLayout(new GridBagLayout());

		// affichage des composants
		affiche();

		// attribut du JPanel
	}

	public void affiche() {

		int rows = 0;

		if (!getActivitePanelCompJLabels().isEmpty()) {
			for (ActivitePanelCompJLabel a : getActivitePanelCompJLabels()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		this.revalidate();
	}

	private List<ActivitePanelCompJLabel> activitePanelCompJLabels = null;

	public List<ActivitePanelCompJLabel> getActivitePanelCompJLabels() {
		if (activitePanelCompJLabels == null)
			activitePanelCompJLabels = new ArrayList<ActivitePanelCompJLabel>();
		return activitePanelCompJLabels;
	}

	public ActivitePanelCompetencesSavoirs getActivitePanelCompetencesSavoirs() {
		return activitePanelCompetencesSavoirs;
	}

	private void setActivitePanelCompetencesSavoirs(ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs) {
		this.activitePanelCompetencesSavoirs = activitePanelCompetencesSavoirs;
	}

	public void addActivitePanelCompJLabels(ActivitePanelCompJLabel activitePanelCompJLabel) {
		getActivitePanelCompJLabels().add(activitePanelCompJLabel);
	}

	public void addCompetence() throws Exception {
		addActivitePanelCompJLabels(new ActivitePanelCompJLabel());

	}

}
