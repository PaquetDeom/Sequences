package fr.paquet.ihm.auteur.creation;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
	JPanelAuteurNom jtfNom = null;
	JPanelAuteurPrenom jtfPrenom = null;

	private Auteur getAuteur() {
		return (Auteur) getModifyObject();
	}

	public JModifyAuteur(Object object) throws Exception {
		super(object);
		jtfNom = new JPanelAuteurNom(new JLabel("Nom :"), new JTextField());
		jtfPrenom = new JPanelAuteurPrenom(new JLabel("Prenom :"), new JTextField());

		if (getAuteur() != null) {
			jtfNom.setText(getAuteur().getNom());
			jtfPrenom.setText(getAuteur().getPrenom());

		}
	}

	public void save() {
		try {
			if (getAuteur() == null)
				setModifyObject(new Auteur(jtfNom.getText(), jtfPrenom.getText()));

			new AuteurFactory().persist(getAuteur());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
