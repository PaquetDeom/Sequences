package fr.paquet.ihm.auteur;

import javax.swing.JDialog;

import fr.paquet.dataBase.User;
import main.MainFrame;

public class JDialogAuteur extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelAuteur jPanelAuteur = null;
	private User user = null;

	public JDialogAuteur() throws Exception {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Identification de l'auteur");
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// setteur des elements
		setJPanelAuteur(new JPanelAuteur(this));

		// ajout du panel
		setContentPane(getJPanelAuteur());

	}

	private JPanelAuteur getJPanelAuteur() {
		return jPanelAuteur;
	}

	private void setJPanelAuteur(JPanelAuteur jPanelAuteur) {
		this.jPanelAuteur = jPanelAuteur;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
