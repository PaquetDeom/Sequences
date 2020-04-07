package main;

import java.awt.EventQueue;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.PrepareConnection;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;

public class Main {

	/**
	 * Demmarrage de l application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					// creation de la mainFrame
					MainFrame mainFrame = MainFrame.getUniqInstance();
					mainFrame.setVisible(true);

					// tentative de connexion à la base
					connectDataBase();

				} catch (Exception e) {

					// fermeture avec erreur
					System.out.println("Fermeture avec erreur");
					new AlertWindow(AlertType.ERREUR, "Fatal Erreur");
					e.printStackTrace();
					FermetureAvecErreur();

				}
			}
		});
	}

	public static void Fermeture() {
		new AlertWindow(AlertType.QUESTION, "Etes-vous sûre de vouloir quitter ?", new AlertListener() {

			@Override
			public void buttonClick(String button) {
				if (button.equals("Oui"))
					FermetureSansErreur();

			}
		});
	}

	public static void FermetureSansErreur() {

		System.exit(0);
	}

	public static void FermetureAvecErreur() {

		System.exit(1);
	}

	public static void connectDataBase() {

		try {

			Connect.setPConnexion(new PrepareConnection(null));
			Connect.getPConnexion().prepareUser();
			Connect.getPConnexion().prepareAuteur();

		} catch (Exception e) {

			e.printStackTrace();
			FermetureAvecErreur();

		}
	}

}
