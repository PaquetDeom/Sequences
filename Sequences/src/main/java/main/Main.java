package main;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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

					// fermeture du logiciel
					WindowListener l = new WindowAdapter() {
						public void windowClosing(WindowEvent e) {

							new AlertWindow(AlertType.QUESTION, "Etes-vous sûre de vouloir quitter",
									new AlertListener() {

										@Override
										public void buttonClick(String button) {
											if (button.equals("Oui"))
												FermetureSansErreur();

										}
									});

						}
					};

					// add listener
					mainFrame.addWindowListener(l);
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

	public static void FermetureSansErreur() {

		System.exit(0);
	}

	public static void FermetureAvecErreur() {

		System.exit(1);
	}

}
