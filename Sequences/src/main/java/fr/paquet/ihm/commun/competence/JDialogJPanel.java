package fr.paquet.ihm.commun.competence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class JDialogJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogCompetence jDialogCompetence = null;
	private JDialogJPanelRef jDialogJPanelRef = null;
	private JDialogJPanelButton jDialogJPanelButton = null;

	public JDialogJPanel(JDialogCompetence jDialogCompetence) {
		super();

		// setteur des components
		setjDialogCompetence(jDialogCompetence);
		setjDialogJPanelRef(new JDialogJPanelRef(this));
		setjDialogJPanelButton(new JDialogJPanelButton(this));

		// ajout du layout
		setLayout(new GridBagLayout());

		// attribut du Layout

		// Affichage des components
		add(getjDialogJPanelRef(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		add(getjDialogJPanelButton(), new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
	}

	public JDialogCompetence getjDialogCompetence() {
		return jDialogCompetence;
	}

	public void setjDialogCompetence(JDialogCompetence jDialogCompetence) {
		this.jDialogCompetence = jDialogCompetence;
	}

	public JDialogJPanelRef getjDialogJPanelRef() {
		return jDialogJPanelRef;
	}

	public void setjDialogJPanelRef(JDialogJPanelRef jDialogJPanelRef) {
		this.jDialogJPanelRef = jDialogJPanelRef;
	}

	public JDialogJPanelButton getjDialogJPanelButton() {
		return jDialogJPanelButton;
	}

	public void setjDialogJPanelButton(JDialogJPanelButton jDialogJPanelButton) {
		this.jDialogJPanelButton = jDialogJPanelButton;
	}

}
