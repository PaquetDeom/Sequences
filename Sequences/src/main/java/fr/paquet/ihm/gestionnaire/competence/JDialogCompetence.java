package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.principal.sequence.SequencePanel;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.SequenceVersion;
import main.MainOnglet;

public class JDialogCompetence extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	@SuppressWarnings("unchecked")
	public JDialogCompetence(SequenceVersion sequence, SequencePanel sequencePanel) {
		super("Gestionnaire de compétences", sequence);

		setSequencePanel(sequencePanel);

		if (!getSequenceVersion().getCompetenceIntermediaires().isEmpty()) {
			compIntsSelect = (List<CompetenceIntermediaire>) ((ArrayList<CompetenceIntermediaire>) getSequenceVersion()
					.getCompetenceIntermediaires()).clone();
			setButtomPanel();
			affiche();
			if (!getSequenceVersion().getSavoirAssocies().isEmpty())
				setSavoirAssocieSelected(
						(List<SavoirAssocie>) ((ArrayList<SavoirAssocie>) getSequenceVersion().getSavoirAssocies())
								.clone());

		}

		affiche();
	}

	private List<SavoirAssocie> savAssSelect = new ArrayList<SavoirAssocie>();

	public List<SavoirAssocie> getSavoirAssocieSelected() {
		return savAssSelect;
	}

	public void setSavoirAssocieSelected(List<SavoirAssocie> savoirAssocies) {
		this.savAssSelect = savoirAssocies;
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

		if (button.getText().equals("Valider")) {
			// set les listes
			getSequenceVersion().setCompetenceIntermediaires(rangeComp(getCompIntsSelect()));
			getSequenceVersion().setSavoirAssocies(getSavoirAssocieSelected());

			// affiche les composants
			try {
				getSequencePanel().getSequencePanelButtomComp().getSequencePanelButtomCompCompSavoir()
						.setCompetenceIntermediaires(rangeComp(getCompIntsSelect()));
				getSequencePanel().getSequencePanelButtomComp().getSequencePanelButtomCompCompSavoir()
						.setSavoirAssocie(getSequenceVersion().getSavoirAssocies());
				getSequencePanel().getSequencePanelButtomComp().getSequencePanelButtomCompCompSavoir().affiche();
				MainOnglet.getUniqInstance().affiche();
			} catch (BadLocationException e) {
				e.printStackTrace();
				new AlertWindow(AlertType.ERREUR, "Affichage impossible");
			}

			this.dispose();
		}

		if (button.getText().equals("Annuler"))
			this.dispose();

	}

	private List<CompetenceIntermediaire> rangeComp(List<CompetenceIntermediaire> compIntsSelect2) {
		List<CompetenceIntermediaire> compInts = new ArrayList<CompetenceIntermediaire>();
		List<Competence> comps = new ArrayList<Competence>();

		for (CompetenceIntermediaire comp : compIntsSelect2) {
			Competence cp = comp.getCompetence();
			if (!comps.contains(cp))
				comps.add(cp);
		}

		for (Competence comp : comps) {
			for (CompetenceIntermediaire compa : compIntsSelect2) {
				if (compa.getCompetence() == comp)
					compInts.add(compa);
			}

		}

		return compInts;
	}

	@Override
	protected void setButtomPanel() {
		this.buttomPanel = new ButtomPanelCompetence(this);

	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	@Override
	protected void addButton() {

		JButton buttonOui = new JButton("Valider");
		buttonOui.addActionListener(this);

		JButton buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(this);

		getButtons().add(buttonOui);
		getButtons().add(buttonAnnuler);

	}

}
