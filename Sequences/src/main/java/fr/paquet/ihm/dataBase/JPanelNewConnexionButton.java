package fr.paquet.ihm.dataBase;

import javax.swing.JPanel;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.User;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelButtonAnnulOk;
import fr.paquet.io.dataBase.WriteFileUser;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelNewConnexionButton extends JPanelButtonAnnulOk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelNewConnexionButton(JPanelNewConnexion jPanelNewConnexion) {
		super(jPanelNewConnexion);

		// ajout du layout
		setLayout(new BorderLayout());

		// Affichage
		JPanel panelbtn = new JPanel();
		add(panelbtn, BorderLayout.SOUTH);
		panelbtn.setLayout(new GridLayout(0, 3, 0, 0));
		panelbtn.add(new JPanel());
		panelbtn.add(getBtnAnnul());
		panelbtn.add(getBtnOk());
	}

	@Override
	public void setjPanel(JPanel panel) {
		this.panel = panel;

	}

	@Override
	public void setBtnAnnul(JButton btnAnnul) {

		btnAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JPanelNewConnexion jp = (JPanelNewConnexion) getJPanel();

				try {
					Connect.getUniqInstance();
					jp.getjDialogIdDataBase().dispose();
				} catch (Exception e) {
					e.printStackTrace(System.out);
					new AlertWindow(AlertType.ERREUR, "Le logiciel ne peut pas se connecter à la base de données");
				}

			}
		});
		this.btnAnnul = btnAnnul;
	}

	@Override
	public void setBtnOk(JButton btnOk) {

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JPanelNewConnexion jp = (JPanelNewConnexion) getJPanel();

				String utilisateur = jp.getjPanelNewUser().getjTextField().getText();
				String pass = jp.getjPanelNewPass().getjTextField().getText();

				try {
					new WriteFileUser(new User(utilisateur, pass));
					Connect.getUniqInstance();
					jp.getjDialogIdDataBase().dispose();
				} catch (Exception e) {
					e.printStackTrace(System.out);
					new AlertWindow(AlertType.ERREUR, e.getMessage());

				}

			}
		});

		this.btnOk = btnOk;
	}

}
