package fr.paquet.ihm.auteur.creation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.sequence.AuteurFactory;
import fr.paquet.ihm.auteur.JPanelAuteurNom;
import fr.paquet.ihm.auteur.JPanelAuteurPrenom;
import fr.paquet.ihm.commun.JModifyDialog;
import fr.paquet.sequence.Auteur;

public class JModifyAuteur extends JModifyDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Auteur getAuteur() {
		return (Auteur) getModifyObject();
	}

	public JModifyAuteur(Object object) throws Exception {
		super(object);

		if (getAuteur() != null) {
			getJtfNom().setText(getAuteur().getNom());
			getJtfPrenom().setText(getAuteur().getPrenom());
		}

		JPanel panel = new JPanel(new GridBagLayout());

		panel.add(getJtfNom(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		panel.add(getJtfPrenom(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		getMaintenancePanel().add(panel);
	}

	public void save() {
		try {
			if (getAuteur() == null)
				setModifyObject(
						new Auteur(getJtfNom().getText(), getJtfPrenom().getText(), Connect.getPConnexion().getUser()));

			new AuteurFactory().persist(getAuteur());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanelAuteurNom jtfNom = null;

	private JPanelAuteurNom getJtfNom() {
		if (jtfNom == null)
			jtfNom = new JPanelAuteurNom(new JLabel("Nom :"), new JTextField());
		return jtfNom;
	}

	private JPanelAuteurPrenom jtfPrenom = null;

	private JPanelAuteurPrenom getJtfPrenom() {
		if (jtfPrenom == null)
			jtfPrenom = new JPanelAuteurPrenom(new JLabel("Prenom :"), new JTextField());
		return jtfPrenom;
	}

}
