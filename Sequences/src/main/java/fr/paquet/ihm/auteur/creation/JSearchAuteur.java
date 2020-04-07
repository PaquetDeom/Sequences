package fr.paquet.ihm.auteur.creation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.paquet.dataBase.Factory.sequence.AuteurFactory;
import fr.paquet.ihm.auteur.JPanelAuteurNom;
import fr.paquet.ihm.commun.JSearchDialog;
import fr.paquet.sequence.Auteur;

public class JSearchAuteur extends JSearchDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanelAuteurNom jPanelAuteurNom = null;
	private String nom = null;

	public JSearchAuteur(String nom) throws Exception {
		super();

		setNom(nom);
		doSearchAction();
		getPanelCritere().add(getJPanelAuteurNom(nom));
	}

	private void setNom(String nom) {
		this.nom = nom;
	}

	private String getNom() {
		return nom;
	}

	private static JPanelAuteurNom getJPanelAuteurNom(String nom) {
		JPanelAuteurNom jPanelAuteurNom = new JPanelAuteurNom(new JLabel("Nom :"), new JTextField());
		jPanelAuteurNom.getjTextField().setText(nom);
		return jPanelAuteurNom;
	}

	@Override
	public List getValues() {
		if (JSearchAuteur.getJPanelAuteurNom(getNom()) == null)
			return new ArrayList();
		AuteurFactory aF = new AuteurFactory();
		try {
			return aF.findListAuteurByName(JSearchAuteur.getJPanelAuteurNom(getNom()).getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String[] getColumnsName() {
		return new String[] { "nom", "prenom" };
	}

	@Override
	public Class[] getColumnsClass() {
		return new Class[] { String.class, String.class };
	}

	@Override
	public Object getListValue(Object object, int columnIndex) {
		Auteur a = (Auteur) object;
		switch (columnIndex) {
		case 0:
			return a.getNom();
		case 1:
			return a.getPrenom();
		}
		return "";
	}

	@Override
	protected Class getDialogClass() {
		return JModifyAuteur.class;
	}

}
