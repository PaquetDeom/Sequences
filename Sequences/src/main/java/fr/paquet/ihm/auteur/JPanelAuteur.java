package fr.paquet.ihm.auteur;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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
		add(getJPanelAuteurNom(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(getJPanelAuteurButton(), new GridBagConstraints(0, 1, 1, 1, 1, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

	}

	private JButton buttonOK = null;

	public JButton getButtonOk() {
		if (buttonOK == null)
			buttonOK = new JButton("Valider");
		return buttonOK;
	}

	private JButton buttonAnnul = null;

	public JButton getButtonAnnul() {
		if (buttonAnnul == null)
			buttonAnnul = new JButton("Annuler");
		return buttonAnnul;
	}

	private JPanel getJPanelAuteurButton() {

		// création des composants
		JPanel panel = new JPanel(new GridBagLayout());

		// ajout des composants aux panels
		panel.add(getButtonOk(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(getButtonAnnul(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		return panel;
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
