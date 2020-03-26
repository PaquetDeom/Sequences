package main;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.User;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.dataBase.JDialogIdDataBase;

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

					// tentative de connexion à la base
					connectDataBase();

					mainFrame.setVisible(true);

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

	private static void FermetureSansErreur() {

		System.exit(0);
	}

	private static void FermetureAvecErreur() {

		System.exit(1);
	}

	public static void connectDataBase() {

		try {
			Connect.getUniqInstance();
		} catch (Exception e) {
			try {
				new JDialogIdDataBase();

			} catch (Exception e1) {
				e1.printStackTrace();
				FermetureAvecErreur();
			}

		}
	}

}
