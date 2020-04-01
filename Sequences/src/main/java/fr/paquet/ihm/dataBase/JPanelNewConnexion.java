package fr.paquet.ihm.dataBase;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelNewConnexion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogIdDataBase jDialogIdDataBase = null;
	private JPanelNewUser jPanelNewUser = null;
	private JPanelNewPass jPanelNewPass = null;
	private JPanelNewConnexionButton jPanelNewConnexionButton = null;

	public JPanelNewConnexion(JDialogIdDataBase jDialogIdDataBase) {
		super();

		// setteur des éléments
		setjDialogIdDataBase(jDialogIdDataBase);
		setjPanelNewUser(new JPanelNewUser(new JLabel("Utilisateur :"), new JTextField(30)));
		setjPanelNewPass(new JPanelNewPass(new JLabel("Mot de passe :"), new JTextField(30)));
		setjPanelNewConnexionButton(new JPanelNewConnexionButton(this));

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des elements aux panel
		add(getjPanelNewUser(), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		add(getjPanelNewPass(), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 0, 5), 0, 0));
		add(getjPanelNewSequenceButton(), new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));

	}

	private JPanelNewConnexionButton getjPanelNewSequenceButton() {
		return jPanelNewConnexionButton;
	}

	private void setjPanelNewConnexionButton(JPanelNewConnexionButton jPanelNewConnexionButton) {
		this.jPanelNewConnexionButton = jPanelNewConnexionButton;
	}

	public JDialogIdDataBase getjDialogIdDataBase() {
		return jDialogIdDataBase;
	}

	public void setjDialogIdDataBase(JDialogIdDataBase jDialogIdDataBase) {
		this.jDialogIdDataBase = jDialogIdDataBase;
	}

	public JPanelNewUser getjPanelNewUser() {
		return jPanelNewUser;
	}

	private void setjPanelNewUser(JPanelNewUser jPanelNewUser) {
		this.jPanelNewUser = jPanelNewUser;
	}

	public JPanelNewPass getjPanelNewPass() {
		return jPanelNewPass;
	}

	private void setjPanelNewPass(JPanelNewPass jPanelNewPass) {
		this.jPanelNewPass = jPanelNewPass;
	}

}
