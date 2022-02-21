package fr.paquet.ihm.principal.progression;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class ProgressionPanelButton extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgressionPanel progressionPanel = null;

	public ProgressionPanelButton(ProgressionPanel progressionPanel) {
		super();

		// set des composants
		setProgressionPanel(progressionPanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des constrains
		add(new JLabel("Progression"), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getProgressionPanelButtonProgression(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new JSeparator(), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new JLabel("Module"), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getProgressionPanelButtonModule(), new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

	}

	private ProgressionPanelButtonModule progressionPanelButtonModule = null;
	private ProgressionPanelButtonProgression progressionPanelButtonProgression = null;
	
	private ProgressionPanelButtonProgression getProgressionPanelButtonProgression() {
		if (progressionPanelButtonProgression == null)
			progressionPanelButtonProgression = new ProgressionPanelButtonProgression(this);
		return progressionPanelButtonProgression;
	}

	private Component getProgressionPanelButtonModule() {
		if(progressionPanelButtonModule == null)
			progressionPanelButtonModule = new ProgressionPanelButtonModule(this);
		return progressionPanelButtonModule;
	}

	private void setProgressionPanel(ProgressionPanel progressionPanel) {
		this.progressionPanel = progressionPanel;

	}

	public ProgressionPanel getProgressionPanel() {
		return progressionPanel;
	}

}
