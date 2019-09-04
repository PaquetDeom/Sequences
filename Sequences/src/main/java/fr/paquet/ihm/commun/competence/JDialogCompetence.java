package fr.paquet.ihm.commun.competence;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.referentiel.*;
import main.MainFrame;

public abstract class JDialogCompetence extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogJPanel jDialogJpanel = null;
	protected List<CompetenceIntermediaire> competenceIntermediaires = null;
	protected List<Savoir> savoirs = null;

	public JDialogCompetence() throws Exception {
		super(MainFrame.getUniqInstance());

		// setteur des elements
		setjDialogJpanel(new JDialogJPanel(this));
		setCompetenceIntermediaires(new ArrayList<CompetenceIntermediaire>());
		setSavoirs(new ArrayList<Savoir>());

		// ajout du Panel
		setContentPane(getjDialogJpanel());
	}

	public JDialogJPanel getjDialogJpanel() {
		return jDialogJpanel;
	}

	private void setjDialogJpanel(JDialogJPanel jDialogJpanel) {
		this.jDialogJpanel = jDialogJpanel;
	}

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		return competenceIntermediaires;
	}

	public List<Savoir> getSavoirs() {
		return savoirs;
	}

	public abstract void setCompetenceIntermediaires(List<CompetenceIntermediaire> competenceIntermediaires);

	public abstract void setSavoirs(List<Savoir> savoirs);

}
