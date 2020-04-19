package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;
import fr.paquet.ihm.commun.gestionnaire.SelectionListener;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.sequence.Sequence;

public class JDialogCompetence extends JDialogGestion implements SelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sequence sequence = null;

	public JDialogCompetence(Sequence sequence) throws Exception {
		super("Gestionnaire de compétences");

		// setteur des elements
		setSequence(sequence);

		// listener
		getJtreeGestionnaireCompetence().addSelectionListeners(this);

	}

	public Sequence getSequence() {
		return sequence;
	}

	private void setSequence(Sequence sequence) {
		this.sequence = sequence;
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

	private List<CompetenceIntermediaire> getCompetencesSequence() {
		return getSequence().getCompetenceIntermediaires();
	}

	private JtreeGestionnaireCompetence jtreeGestionnaireCompetence = null;

	private JtreeGestionnaireCompetence getJtreeGestionnaireCompetence() {
		if (jtreeGestionnaireCompetence == null)
			jtreeGestionnaireCompetence = new JtreeGestionnaireCompetence(getCompetences());
		return jtreeGestionnaireCompetence;
	}

	@Override
	protected void setJButtomPanel(JPanel jPanel) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setJSplitPaneLeft() {
		if (getCompetences() != null && !getCompetences().isEmpty())
			this.leftComponent = getJtreeGestionnaireCompetence();

	}

	@Override
	protected void setJSplitPaneRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Annuler"))
			this.dispose();

	}

	@Override
	public void SelectionChange(SelectedEvent eventObject) {
		String text = (String) eventObject.getSource();
		System.out.println(text);

	}

}
