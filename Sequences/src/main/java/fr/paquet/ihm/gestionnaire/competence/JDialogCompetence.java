package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.sequence.Sequence;

public class JDialogCompetence extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogCompetence(Sequence sequence) throws Exception {
		super("Gestionnaire de compétences", sequence);

	}

	public Sequence getSequence() {
		return (Sequence) getObject();
	}

	private List<Competence> getCompetences() {

		List<Competence> comps = new ArrayList<Competence>();

		for (Capacite cap : getSequence().getReferentiel().getCapacites()) {
			for (Competence comp : cap.getCompetences()) {
				comps.add(comp);
			}
		}
		return comps;
	}

	public List<CompetenceIntermediaire> getCompetencesSequence() {
		return getSequence().getCompetenceIntermediaires();
	}

	@Override
	protected void setJtreeGestionnaire() {
		JtreeGestionnaireCompetence jtreeGestionnaire = new JtreeGestionnaireCompetence(getCompetences());
		this.jtreeGestionnaire = jtreeGestionnaire;
	}

	@Override
	protected void setJPanelGestionnaireRight() {
		JPanelGestionnaireCompetenceRight panel = new JPanelGestionnaireCompetenceRight(this);
		this.jPanelGestionnaireRight = panel;

	}

	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Annuler"))
			this.dispose();

	}

	@Override
	protected void setButtomPanel() {
		// TODO Auto-generated method stub
		
	}

}
