package fr.paquet.ihm.principal.progression;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import fr.paquet.ihm.alert.AlertListener;

public class ProgressionPanelButtonProgression extends JPanel implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgressionPanelButton progressionPanelButton = null;

	public ProgressionPanelButtonProgression(ProgressionPanelButton progressionPanelButton) {
		super();

		// set des composants
		setProgressionPanelButton(progressionPanelButton);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des constrains
		add(getButtonCreer(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getButtonOuvrir(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getButtonImporter(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	}

	private JButton buttonCreer = null;
	private JButton buttonOuvrir = null;
	private JButton buttonImporter = null;

	private JButton getButtonImporter() {
		if (buttonImporter == null)
			buttonImporter = new JButton("Importer");
		return buttonImporter;
	}

	private JButton getButtonOuvrir() {
		if (buttonOuvrir == null)
			buttonOuvrir = new JButton("Ouvrir");
		return buttonOuvrir;
	}

	private JButton getButtonCreer() {
		if (buttonCreer == null)
			buttonCreer = new JButton("Créer");
		return buttonCreer;
	}

	@Override
	public void buttonClick(String button) {
		// TODO Auto-generated method stub

	}

	public ProgressionPanelButton getProgressionPanelButton() {
		return progressionPanelButton;
	}

	private void setProgressionPanelButton(ProgressionPanelButton progressionPanelButton) {
		this.progressionPanelButton = progressionPanelButton;
	}

}
