package fr.paquet.ihm.principal.activite;

import javax.swing.JComponent;

import main.MainOnglet;

public class OngletActivite extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;
	private MainOnglet mainOnglet = null;

	public OngletActivite(MainOnglet mainOnglet) {

		super();

		// setteur des components
		setActivitePanel(new ActivitePanel(this));
		setMainOnglet(mainOnglet);

		// Ajout de l'onglet
		getMainOnglet().addTab(getTitre(), getActivitePanel());

		// rempli la liste des onglets dans MainOnglet
		getMainOnglet().addOngletsActivites(this);
	}

	private String getTitre() {

		if (getMainOnglet().getOngletsActivites().size() != 0) {
			int i = getMainOnglet().getOngletsActivites().size() + 1;
			return "Activité : " + i;
		}

		else
			return "Activité :" + 1;
	}

	private ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	private void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

}
