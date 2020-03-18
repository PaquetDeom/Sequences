package fr.paquet.ihm.dataBase;

import javax.swing.JDialog;

import fr.paquet.dataBase.User;
import main.MainFrame;

public class JDialogIdDataBase extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewConnexion jPanelNewConnexion = null;
	private User user = null;

	public JDialogIdDataBase() throws Exception {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Identifiant de connexion à la base de données");
		setSize(600, 100);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// setteur des elements
		setjPanelNewConnexion(new JPanelNewConnexion(this));

		// ajout du panel
		setContentPane(getjPanelNewConnexion());

	}

	private JPanelNewConnexion getjPanelNewConnexion() {
		return jPanelNewConnexion;
	}

	private void setjPanelNewConnexion(JPanelNewConnexion jPanelNewConnexion) {
		this.jPanelNewConnexion = jPanelNewConnexion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
