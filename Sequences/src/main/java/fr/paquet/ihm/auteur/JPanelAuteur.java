package fr.paquet.ihm.auteur;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.ihm.auteur.creation.JSearchAuteur;

public class JPanelAuteur extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogAuteur jDialogAuteur = null;

	public JPanelAuteur(JDialogAuteur jDialogAuteur) {
		super();

		// setteur des éléments
		setjDialogAuteur(jDialogAuteur);

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des elements aux panel
		add(getJPanelAuteurNom(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));

	}

	private JPanelAuteurNom jPanelAuteurNom = null;

	public JPanelAuteurNom getJPanelAuteurNom() {
		if (jPanelAuteurNom == null)
			jPanelAuteurNom = new JPanelAuteurNom(new JLabel("Nom :"), new JTextField(30), JSearchAuteur.class);
		return jPanelAuteurNom;
	}

	public JDialogAuteur getjDialogAuteur() {
		return jDialogAuteur;
	}

	public void setjDialogAuteur(JDialogAuteur jDialogAuteur) {
		this.jDialogAuteur = jDialogAuteur;
	}

}
