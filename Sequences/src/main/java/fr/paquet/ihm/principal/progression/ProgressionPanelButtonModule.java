package fr.paquet.ihm.principal.progression;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.paquet.ihm.alert.AlertListener;

public class ProgressionPanelButtonModule extends JPanel implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgressionPanelButton progressionPanelButton = null;

	public ProgressionPanelButtonModule(ProgressionPanelButton progressionPanelButton) {
		super();

		// set des composants
		setProgressionPanelButton(progressionPanelButton);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des constrains
		add(getButtonCreer(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getButtonAjouter(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	}

	private JButton buttonCreer = null;
	private JButton buttonAjouter = null;

	private JButton getButtonAjouter() {
		if (buttonAjouter == null)
			buttonAjouter = new JButton("Ajouter");

		return buttonAjouter;
	}

	private JButton getButtonCreer() {
		if (buttonCreer == null)
			buttonCreer = new JButton("Créer");
		return buttonCreer;
	}

	public ProgressionPanelButton getProgressionPanelButton() {
		return progressionPanelButton;
	}

	private void setProgressionPanelButton(ProgressionPanelButton progressionPanelButton) {
		this.progressionPanelButton = progressionPanelButton;
	}

	@Override
	public void buttonClick(String button) {
		// TODO Auto-generated method stub

	}

}
