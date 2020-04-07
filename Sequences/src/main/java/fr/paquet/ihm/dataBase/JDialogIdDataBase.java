package fr.paquet.ihm.dataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.PrepareConnection;
import fr.paquet.dataBase.User;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.io.dataBase.WriteFileUser;
import main.Main;
import main.MainFrame;

public class JDialogIdDataBase extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogIdDataBase() {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Identifiant de connexion à la base de données");
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setModal(true);

		// ajout du panel
		setContentPane(getjPanelNewConnexion());

		// listener
		buttonok = getjPanelNewConnexion().getjPanelNewSequenceButton().getBtnOk();
		buttonannul = getjPanelNewConnexion().getjPanelNewSequenceButton().getBtnAnnul();
		buttonok.addActionListener(this);
		buttonannul.addActionListener(this);

		setVisible(true);

	}

	private JPanelNewConnexion jPanelNewConnexion = null;

	private JPanelNewConnexion getjPanelNewConnexion() {
		if (jPanelNewConnexion == null)
			jPanelNewConnexion = new JPanelNewConnexion(this);
		return jPanelNewConnexion;
	}

	private JButton buttonok = null;
	private JButton buttonannul = null;

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = (JButton) event.getSource();

		if (source == buttonok) {

			String utilisateur = getjPanelNewConnexion().getjPanelNewUser().getjTextField().getText();
			String pass = getjPanelNewConnexion().getjPanelNewPass().getjTextField().getText();

			try {
				Connect.getPConnexion().setUser(new User(utilisateur, pass));
				Connect.getEmf();
				new WriteFileUser(Connect.getPConnexion().getUser());
				dispose();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				new AlertWindow(AlertType.ERREUR, "Le logiciel ne peut pas se connecter à la base de données");

			}
		}

		if (source == buttonannul) {

			try {
				Connect.getEmf();
				dispose();
			} catch (Exception e) {
				e.printStackTrace(System.out);
				new AlertWindow(AlertType.ERREUR, "Le logiciel ne peut pas se connecter à la base de données");
			}

		}

	}

}
