package fr.paquet.ihm.commun.competence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class JDialogJPanelRef extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogJPanel jDialogJPanel = null;
	private JDialogJPanelCompetence jDialogJPanelCompetence = null;
	

	public JDialogJPanelRef(JDialogJPanel jDialogPanel) {
		super();

		// setteur des components
		setjDialogJPanel(jDialogPanel);
		setjDialogJPanelCompetence(new JDialogJPanelCompetence(this));
		
		// ajout du layout
		setLayout(new GridBagLayout());

		// attribut du panel

		// affichege es components
		add(getjDialogJPanelCompetence(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 0), 0, 0));
		
	}

	public JDialogJPanel getjDialogJPanel() {
		return jDialogJPanel;
	}

	private void setjDialogJPanel(JDialogJPanel jDialogJPanel) {
		this.jDialogJPanel = jDialogJPanel;
	}

	public JDialogJPanelCompetence getjDialogJPanelCompetence() {
		return jDialogJPanelCompetence;
	}

	private void setjDialogJPanelCompetence(JDialogJPanelCompetence jDialogJPanelCompetence) {
		this.jDialogJPanelCompetence = jDialogJPanelCompetence;
	}


}
