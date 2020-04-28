package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.SequenceVersion;
import main.Main;
import main.MainFrame;
import main.MainOnglet;

public class ActionQuitter extends ActionBDA implements AlertListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionQuitter() {
		super();
		putValue(NAME, getName());
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (MainOnglet.getUniqInstance().getOngletSequence() != null) {

			SequenceVersion sequenceVersion = MainFrame.getUniqInstance().getSequenceVersion();
			CompareSequenceWithDB compare;
			try {
				compare = new CompareSequenceWithDB(sequenceVersion);
				if (!compare.isSame() && sequenceVersion.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
					new AlertWindow(AlertType.QUESTION, "Voulez vous enregistrer la séquence", this);
				else
					Main.Fermeture();
			} catch (Exception e1) {
				new AlertWindow(AlertType.ERREUR, "Comparaison impossible");
				Main.FermetureAvecErreur();
				e1.printStackTrace();
			}

		} else
			Main.Fermeture();

	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

	@Override
	public String getName() {

		return "Quitter";
	}

	@Override
	protected void Enable() {

	}

	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui")) {
			try {
				new SequenceVersionFactory().persist(MainFrame.getUniqInstance().getSequenceVersion());
				Main.FermetureSansErreur();
			} catch (Exception e) {
				new AlertWindow(AlertType.ERREUR, "Sauvegarde de la sequence impossible");
				e.printStackTrace();
				Main.FermetureAvecErreur();
			}
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

}
