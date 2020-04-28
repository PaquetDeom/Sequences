package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.ButtomPanel;
import fr.paquet.ihm.gestionnaire.savoir.JDialogSavoir;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;

public class ButtomPanelCompetence extends ButtomPanel implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtomPanelCompetence(JDialogCompetence jDialogCompetence) {
		super(jDialogCompetence);
	}

	@Override
	public Object getListValue(Object object, int columnIndex) {
		CompetenceIntermediaire comp = (CompetenceIntermediaire) object;
		switch (columnIndex) {
		case 0:
			return comp.toString();

		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getValues() {
		return getJDialogCompetence().getCompIntsSelect();
	}

	private JDialogCompetence getJDialogCompetence() {
		return (JDialogCompetence) getjDialogGestion();
	}

	@Override
	public String[] getColumnsName() {

		return new String[] { "Compétences Intermédaires" };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getColumnsClass() {

		return new Class[] { String.class };
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (getCompIntSelected() == null)
			new AlertWindow(AlertType.ATTENTION, "Veuillez sélectionner une compétence");
		else {

			if (button.getText().equals("Supprimer")) {

				if (!getJDialogCompetence().getSequenceVersion().getActivites().isEmpty()) {
					new AlertWindow(AlertType.QUESTION, "La compétence va être supprimée de toute les activités", this);
				} else {
					supprSequence();
					affiche();
				}

			}

			if (button.getText().equals("Savoir")) {

				new JDialogSavoir(getCompIntSelected(), getJDialogCompetence().getSequenceVersion(),
						getJDialogCompetence());
			}
		}

	}

	private void supprSequence() {

		getJDialogCompetence().getCompIntsSelect().remove(getCompIntSelected());

		List<Savoir> savoirsAut = new ArrayList<Savoir>();

		for (CompetenceIntermediaire compInt : getJDialogCompetence().getCompIntsSelect()) {
			for (Savoir savoir : compInt.getCompetence().getSavoirs()) {
				savoirsAut.add(savoir);
			}
		}

		for (SavoirAssocie savAss : getJDialogCompetence().getSavoirAssocieSelected()) {
			if (savoirsAut.isEmpty())
				getJDialogCompetence().setSavoirAssocieSelected(new ArrayList<SavoirAssocie>());
			else {
				if (!savoirsAut.contains(savAss.getSavoir()))
					getJDialogCompetence().getSavoirAssocieSelected().remove(savAss);
			}
		}
	}

	private void supprActivite(CompetenceIntermediaire compInt) {

		for (Activite_1 act : getJDialogCompetence().getSequenceVersion().getActivites()) {
			if (!act.getCompetencesIntermediaires().isEmpty()) {
				if (act.getCompetencesIntermediaires().contains(compInt))

					act.getCompetencesIntermediaires().remove(compInt);
			}
		}

	}

	@Override
	protected void setButtons(List<JButton> buttons) {
		buttons.add(new JButton("Supprimer"));
		buttons.add(new JButton("Savoir"));
		this.buttons = buttons;

	}

	private CompetenceIntermediaire compIntSelected = null;

	private CompetenceIntermediaire getCompIntSelected() {
		return compIntSelected;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		DefaultListSelectionModel dLSM = (DefaultListSelectionModel) event.getSource();
		int i = dLSM.getMinSelectionIndex();
		this.compIntSelected = getJDialogCompetence().getCompIntsSelect().get(i);

	}

	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui")) {
			supprActivite(getCompIntSelected());
			supprSequence();
			affiche();
		}

	}
}
