package fr.paquet.ihm.auteur.creation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.paquet.dataBase.Factory.sequence.AuteurFactory;
import fr.paquet.ihm.commun.JSearchDialog;
import fr.paquet.sequence.Auteur;

public class JSearchAuteur extends JSearchDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanelSearchAuteur jPanelSearchAuteur = null;

	private Auteur auteur = null;

	public JSearchAuteur(String nom) throws Exception {
		super();

		jPanelSearchAuteur = new JPanelSearchAuteur(new JLabel("Nom :"), new JTextField(30));
		jPanelSearchAuteur.getjTextField().setText(nom);
		doSearchAction();
	}

	@Override
	public List getValues() {
		if (jPanelSearchAuteur == null)
			return new ArrayList();
		AuteurFactory aF = new AuteurFactory();
		try {
			return aF.findListAuteurByName(jPanelSearchAuteur.getText());
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
