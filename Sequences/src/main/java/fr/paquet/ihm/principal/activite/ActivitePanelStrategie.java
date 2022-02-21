package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ActivitePanelStrategie extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelStrategie(ActivitePanel activitePanel) {
		super();

		// set des composants
		setActivitepanel(activitePanel);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(getPanelStrategieTitre(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getPanelStrtegieDemarche(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getJSplitPaneActProFEleve(), new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attribut du panel

	}

	private JSplitPaneActProFEleve jSplitPaneActProFEleve = null;

	private JSplitPaneActProFEleve getJSplitPaneActProFEleve() {
		if (jSplitPaneActProFEleve == null)
			jSplitPaneActProFEleve = new JSplitPaneActProFEleve(this);
		return jSplitPaneActProFEleve;
	}

	private JpanelStrtegieDemarche jpanelStrtegieDemarche = null;

	public JpanelStrtegieDemarche getPanelStrtegieDemarche() {
		if (jpanelStrtegieDemarche == null)
			jpanelStrtegieDemarche = new JpanelStrtegieDemarche(this);
		return jpanelStrtegieDemarche;
	}

	private JPanelStrategieTitre jPanelStrategieTitre = null;

	private JPanelStrategieTitre getPanelStrategieTitre() {
		if (jPanelStrategieTitre == null)
			jPanelStrategieTitre = new JPanelStrategieTitre(this);
		return jPanelStrategieTitre;
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;
	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
	}

	

}
