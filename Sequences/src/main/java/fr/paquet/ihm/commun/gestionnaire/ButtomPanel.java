package fr.paquet.ihm.commun.gestionnaire;

import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class ButtomPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table = null;

	public ButtomPanel(JDialogGestion jDialogGestion) {
		super();

		// ajout du layout
		setLayout(new GridBagLayout());
	}

}
