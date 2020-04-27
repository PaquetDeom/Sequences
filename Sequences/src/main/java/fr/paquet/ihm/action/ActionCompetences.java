package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.gestionnaire.competence.JDialogCompetence;
import fr.paquet.sequence.SequenceVersion;

public class ActionCompetences extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionCompetences() {
		super();
		putValue(NAME, getName());
		if (sequenceVersion == null)
			setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {
		if (sequence != null)
			setEnabled(true);
		this.sequenceVersion = sequence;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (sequenceVersion.isModifiable(Connect.getPConnexion().getUser().getAuteur())) {
			new JDialogCompetence(sequenceVersion);
			
		} else
			new AlertWindow(AlertType.INFORMATION, "Vous ne pouvez pas modifier cette séquence");

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Gestion compétences";
	}

}
