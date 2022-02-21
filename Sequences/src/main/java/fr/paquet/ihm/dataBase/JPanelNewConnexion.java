package fr.paquet.ihm.dataBase;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class JPanelNewConnexion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogIdDataBase jDialogIdDataBase = null;

	public JPanelNewConnexion(JDialogIdDataBase jDialogIdDataBase) {
		super();

		// setteur des éléments
		setjDialogIdDataBase(jDialogIdDataBase);

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

	private JPanelNewConnexionButton jPanelNewConnexionButton = null;

	public JPanelNewConnexionButton getjPanelNewSequenceButton() {
		if (jPanelNewConnexionButton == null)
			jPanelNewConnexionButton = new JPanelNewConnexionButton(this);
		return jPanelNewConnexionButton;
	}

	public JDialogIdDataBase getjDialogIdDataBase() {
		return jDialogIdDataBase;
	}

	public void setjDialogIdDataBase(JDialogIdDataBase jDialogIdDataBase) {
		this.jDialogIdDataBase = jDialogIdDataBase;
	}

	private JPanelNewUser jPanelNewUser = null;

	public JPanelNewUser getjPanelNewUser() {
		if (jPanelNewUser == null)
			jPanelNewUser = new JPanelNewUser("Utilisateur");
		return jPanelNewUser;
	}

	private JPanelNewPass jPanelNewPass = null;

	public JPanelNewPass getjPanelNewPass() {
		if (jPanelNewPass == null)
			jPanelNewPass = new JPanelNewPass("Mot de pass");
		return jPanelNewPass;
	}

}
