package fr.paquet.ihm.principal.progression;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProgressionPanelCenter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgressionPanel progressionPanel = null;

	public ProgressionPanelCenter(ProgressionPanel progressionPanel) {
		super();

		// set des composants
		setProgressionPanel(progressionPanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des constrains
		add(new JLabel("Center"), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	private void setProgressionPanel(ProgressionPanel progressionPanel) {
		this.progressionPanel = progressionPanel;

	}

	public ProgressionPanel getProgressionPanel() {
		return progressionPanel;
	}

}
