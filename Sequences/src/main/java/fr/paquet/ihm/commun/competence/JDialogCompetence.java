package fr.paquet.ihm.commun.competence;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.referentiel.*;
import fr.paquet.sequence.Sequence;
import main.MainFrame;

public class JDialogCompetence extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogJPanel jDialogJpanel = null;
	private List<CompetenceIntermediaire> compInts = null;

	public JDialogCompetence(Referentiel referentiel) throws Exception {
		super(MainFrame.getUniqInstance());

		// setteur des elements
		setjDialogJpanel(new JDialogJPanel(this));
		// initialisation des compétences
		for (Capacite cap : referentiel.getCapacites()) {
			for (Competence comp : cap.getCompetences()) {
				for (CompetenceIntermediaire compInt : comp.getCompetencesIntermediaires()) {
					getCompetenceIntermediaires().add(compInt);
				}
			}
		}

		// ajout du Panel
		setContentPane(getjDialogJpanel());
	}

	public JDialogCompetence(Sequence sequence) {
		super();

		// setteur des elements
		setjDialogJpanel(new JDialogJPanel(this));
		// initialisation des competences

		for (CompetenceIntermediaire competenceIntermediaire : sequence.getCompetenceIntermediaires()) {
			getCompetenceIntermediaires().add(competenceIntermediaire);
		}
		// ajout du Panel
		setContentPane(getjDialogJpanel());
	}

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		if (compInts == null)
			compInts = new ArrayList<CompetenceIntermediaire>();
		return compInts;
	}

	public JDialogJPanel getjDialogJpanel() {
		return jDialogJpanel;
	}

	private void setjDialogJpanel(JDialogJPanel jDialogJpanel) {
		this.jDialogJpanel = jDialogJpanel;
	}

}
