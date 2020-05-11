package fr.paquet.ihm.activite.ressource;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelButtonActiviteRessource extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainPanelActiviteRessource mainPanelActiviteRessource = null;

	public JPanelButtonActiviteRessource(MainPanelActiviteRessource mainPanelActiviteRessource) {
		super();

		// set des components
		setMainPanelActiviteRessource(mainPanelActiviteRessource);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(getBtnValider(), new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getBtnAnnuler(), new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	private JButton btnValider = null;

	public JButton getBtnValider() {
		if (btnValider == null)
			btnValider = new JButton("Valider");
		return btnValider;
	}

	private JButton btnAnnuler = null;

	public JButton getBtnAnnuler() {
		if (btnAnnuler == null)
			btnAnnuler = new JButton("Annuler");
		return btnAnnuler;
	}

	public MainPanelActiviteRessource getMainPanelActiviteRessource() {
		return mainPanelActiviteRessource;
	}

	private void setMainPanelActiviteRessource(MainPanelActiviteRessource mainPanelActiviteRessource) {
		this.mainPanelActiviteRessource = mainPanelActiviteRessource;
	}
}
