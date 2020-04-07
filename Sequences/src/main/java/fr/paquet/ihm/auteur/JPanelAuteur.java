package fr.paquet.ihm.auteur;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.auteur.creation.JSearchAuteur;
import fr.paquet.sequence.Auteur;
import main.Main;

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

	private JPanel getJPanelAuteurButton() {

		// création des composants
		JPanel panel = new JPanel(new GridBagLayout());
		JButton buttonOK = new JButton("OK");
		JButton buttonAnnul = new JButton("Annuler");

		// ajout des composants aux panels
		panel.add(buttonOK, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(buttonAnnul, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				Auteur auteur = (Auteur) getJPanelAuteurNom().getObjet();

				if (auteur != null) {
					Connect.getPConnexion().getUser().setAuteur(auteur);
					getjDialogAuteur().dispose();
				} else
					new AlertWindow(AlertType.ERREUR, "Auteur invalide");

			}
		});

		buttonAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (Connect.getPConnexion().getUser().getAuteur() != null)
					getjDialogAuteur().dispose();
				else {
					new AlertWindow(AlertType.ERREUR, "Vous devez renseigner un auteur");

				}

			}
		});

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
