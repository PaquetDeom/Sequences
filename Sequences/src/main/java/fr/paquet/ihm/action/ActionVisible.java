package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.SequenceVersion;
import main.MainMenu;
import main.MainOnglet;

public class ActionVisible extends ActionBDA implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionVisible() {
		super();
		putValue(NAME, getName());
		setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {
		this.sequenceVersion = sequence;
		Enable();
	}

	public void Enable() {
		if (sequenceVersion != null && !sequenceVersion.isVisible()
				&& Connect.getPConnexion().getUser().getAuteur() == sequenceVersion.getAuteur())
			setEnabled(true);
		else
			setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new AlertWindow(AlertType.QUESTION, "Après cette opération vous ne pourrez plus modifier cette séquence", this);
		MainOnglet.getUniqInstance().afficheVersion();

		MainMenu.getUniqInstance().getActionSave().Enable();
		MainMenu.getUniqInstance().getActionCompetences().Enable();
		MainMenu.getUniqInstance().getActionActivites().Enable();
		
		Enable();

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Rendre visible";
	}

	@Override
	public void buttonClick(String button) {

		if (button.equals("Oui")) {
			sequenceVersion.setVisible(true);
		}
	}

}
