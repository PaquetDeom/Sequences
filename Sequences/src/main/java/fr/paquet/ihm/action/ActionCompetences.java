package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.gestionnaire.competence.JDialogCompetence;
import fr.paquet.ihm.principal.sequence.SequencePanel;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class ActionCompetences extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionCompetences() {
		super();
		putValue(NAME, getName());
		setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {

		this.sequenceVersion = sequence;
		Enable();
	}

	private SequencePanel getSequencePanel() {
		return MainFrame.getUniqInstance().getMainOnglet().getOngletSequence().getSequencePanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new JDialogCompetence(sequenceVersion, getSequencePanel());

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Gestion compétences";
	}

	@Override
	protected void Enable() {
		if (getSequencePanel() != null && sequenceVersion != null
				&& sequenceVersion.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			setEnabled(true);
		else
			setEnabled(false);
	}

}
