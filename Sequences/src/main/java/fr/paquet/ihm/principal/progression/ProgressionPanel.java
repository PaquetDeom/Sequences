package fr.paquet.ihm.principal.progression;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public class ProgressionPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletProgression ongletProgression = null;
	private OngletModule ongletModule = null;
	private ProgressionPanelTitleProgression progressionPanelTitleProgression = null;
	private ProgressionPanelTitleModule progressionPanelTitleModule = null;
	private ProgressionPanelButton progressionPanelButton = null;
	private ProgressionPanelCenter progressionPanelCenter = null;

	public ProgressionPanel(OngletProgression ongletProgression) {
		super();

		// set des composants
		setOngletProgression(ongletProgression);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants

		add(getProgressionPanelButton(), new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelTitleProgression(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelTitleModule(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelCenter(), new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	public ProgressionPanel(OngletModule ongletModule) {
		super();

		// set des composants
		setOngletModule(ongletModule);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants

		add(getProgressionPanelButton(), new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelTitleProgression(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelTitleModule(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getProgressionPanelCenter(), new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	private ProgressionPanelTitleModule getProgressionPanelTitleModule() {
		if (progressionPanelTitleModule == null)
			progressionPanelTitleModule = new ProgressionPanelTitleModule(this);
		return progressionPanelTitleModule;
	}

	public ProgressionPanelCenter getProgressionPanelCenter() {
		if (progressionPanelCenter == null)
			progressionPanelCenter = new ProgressionPanelCenter(this);
		return progressionPanelCenter;
	}

	public ProgressionPanelButton getProgressionPanelButton() {
		if (progressionPanelButton == null)
			progressionPanelButton = new ProgressionPanelButton(this);
		return progressionPanelButton;
	}

	public ProgressionPanelTitleProgression getProgressionPanelTitleProgression() {
		if (progressionPanelTitleProgression == null)
			progressionPanelTitleProgression = new ProgressionPanelTitleProgression(this);
		return progressionPanelTitleProgression;
	}

	private void setOngletProgression(OngletProgression ongletProgression) {
		this.ongletProgression = ongletProgression;

	}

	public OngletProgression getOngletProgression() {
		return ongletProgression;
	}
	
	private void setOngletModule(OngletModule ongletModule) {
		this.ongletModule = ongletModule;

	}

	public OngletModule getOngletModule() {
		return ongletModule;
	}

}
