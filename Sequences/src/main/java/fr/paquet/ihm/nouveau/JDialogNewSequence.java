package fr.paquet.ihm.nouveau;

import javax.swing.JDialog;

import main.MainFrame;

public class JDialogNewSequence extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;

	public JDialogNewSequence() throws Exception {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Création d'une nouvelle séquence");
		setResizable(false);
		setSize(600, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// setteur des elements
		setjPanelNewSequence(new JPanelNewSequence(this));

		// ajout du panel
		setContentPane(getjPanelNewSequence());

	}

	private JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

}
