package fr.paquet.ihm.gestionnaire.competence;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;

import fr.paquet.ihm.commun.gestionnaire.ButtomPanel;
import fr.paquet.ihm.gestionnaire.savoir.JDialogSavoir;
import fr.paquet.referentiel.CompetenceIntermediaire;

public class ButtomPanelCompetence extends ButtomPanel {

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

		if (button.getText().equals("Supprimer")) {
			getJDialogCompetence().getCompIntsSelect().remove(getCompIntSelected());
			affiche();
		}

		if (button.getText().equals("Savoir")) {
			new JDialogSavoir(getCompIntSelected());
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
}
