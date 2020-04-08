package fr.paquet.ihm.auteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.Auteur;
import main.MainFrame;

public class JDialogAuteur extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogAuteur() {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Identification de l'auteur");
		setSize(600, 130);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// ajout du panel
		setContentPane(getJPanelAuteur());

		// listener
		getJPanelAuteur().getButtonOk().addActionListener(this);
		getJPanelAuteur().getButtonAnnul().addActionListener(this);

	}

	private JPanelAuteur jPanelAuteur = null;

	private JPanelAuteur getJPanelAuteur() {
		if (jPanelAuteur == null)
			jPanelAuteur = new JPanelAuteur(this);
		return jPanelAuteur;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		JButton button = (JButton) evt.getSource();
		String buttontext = button.getText();

		Auteur auteur = (Auteur) getJPanelAuteur().getJPanelAuteurNom().getObjet();

		if (buttontext.equals("Valider")) {
			if (auteur != null) {
				Connect.getPConnexion().getUser().setAuteur(auteur);
				try {
					Connect.getPConnexion().save();
				} catch (Exception e) {
					new AlertWindow(AlertType.ERREUR, "Savegarde impossible");
					e.printStackTrace();
				}
				dispose();
			} else
				new AlertWindow(AlertType.ERREUR, "Auteur invalide");
		} else {
			if (Connect.getPConnexion().getUser().getAuteur() != null) {
				dispose();
			} else {
				new AlertWindow(AlertType.ERREUR, "Vous devez renseigner un auteur");

			}
		}
	}

}
