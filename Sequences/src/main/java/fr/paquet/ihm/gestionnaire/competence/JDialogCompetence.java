package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.sequence.Sequence;
import fr.paquet.sequence.SequenceVersion;

public class JDialogCompetence extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public JDialogCompetence(Sequence sequence) {
		super("Gestionnaire de compétences", sequence);

		if (!getSequenceVersion().getCompetenceIntermediaires().isEmpty()) {
			setButtomPanel();
			affiche();
			compIntsSelect = (ArrayList<CompetenceIntermediaire>) ((ArrayList<CompetenceIntermediaire>) getSequenceVersion()
					.getCompetenceIntermediaires()).clone();
		}
	}

	public SequenceVersion getSequenceVersion() {
		return (SequenceVersion) getObject();
	}

	private List<Competence> getCompetences() {

		List<Competence> comps = new ArrayList<Competence>();

		for (Capacite cap : getSequenceVersion().getReferentiel().getCapacites()) {
			for (Competence comp : cap.getCompetences()) {
				comps.add(comp);
			}
		}
		return comps;
	}

	public List<CompetenceIntermediaire> getCompetencesSequence() {
		return getSequenceVersion().getCompetenceIntermediaires();
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

	private List<CompetenceIntermediaire> compIntsSelect = null;

	public List<CompetenceIntermediaire> getCompIntsSelect() {
		if (compIntsSelect == null)
			compIntsSelect = new ArrayList<CompetenceIntermediaire>();
		return compIntsSelect;
	}

	private void addCompetenceIntermediaire(CompetenceIntermediaire compInt) throws Exception {
		if (getCompIntsSelect().contains(compInt))
			throw new Exception("La competence est déja dans la liste");
		else
			getCompIntsSelect().add(compInt);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Ajouter")) {

			if (getJButtomPanel() == null) {
				setButtomPanel();
				affiche();
			}

			CompetenceIntermediaire compInt = (CompetenceIntermediaire) getJPanelGestionnaireRight()
					.getObjectSelected();
			try {
				addCompetenceIntermediaire(compInt);
			} catch (Exception e) {
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}
			getJButtomPanel().affiche();

		}

		if (button.getText().equals("Valider"))
			// TODO

			if (button.getText().equals("Annuler"))
				this.dispose();

	}

	@Override
	protected void setButtomPanel() {
		this.buttomPanel = new ButtomPanelCompetence(this);

	}

}
