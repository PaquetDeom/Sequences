package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.gestionnaire.competence.JDialogCompetence;
import fr.paquet.ihm.principal.sequence.SequencePanel;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class ActionCompetences extends ActionBDA implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionCompetences() {
		super();
		putValue(NAME, getName());
		MainFrame.getUniqInstance().addPropertyChangeListener(this);
		Enable();
	}

	private SequenceVersion getSequenceVersion() {

		return MainFrame.getUniqInstance().getSequenceVersion();

	}

	private SequencePanel getSequencePanel() {
		return MainFrame.getUniqInstance().getMainOnglet().getOngletSequence().getSequencePanel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new JDialogCompetence(getSequenceVersion(), getSequencePanel());

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
		if (getSequenceVersion() != null) {
			if (getSequenceVersion().isModifiable(Connect.getPConnexion().getUser().getAuteur()))
				setEnabled(true);
			else
				setEnabled(false);
		} else
			setEnabled(false);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

}
