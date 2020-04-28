package fr.paquet.ihm.gestionnaire.activite.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.ButtomPanel;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;

public class ButtomPanelCompetenceActivite extends ButtomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtomPanelCompetenceActivite(JDialogCompetenceActivite jDialogCompetenceActivite) {
		super(jDialogCompetenceActivite);

	}

	private JDialogCompetenceActivite getJDialogCompetenceActivite() {
		return (JDialogCompetenceActivite) getjDialogGestion();
	}

	private CompetenceIntermediaire compIntSelected = null;

	private CompetenceIntermediaire getCompIntSelected() {
		return compIntSelected;
	}

	@Override
	public void valueChanged(ListSelectionEvent event) {
		DefaultListSelectionModel dLSM = (DefaultListSelectionModel) event.getSource();
		int i = dLSM.getMinSelectionIndex();
		this.compIntSelected = getJDialogCompetenceActivite().getCompIntsSelect().get(i);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (getCompIntSelected() == null)
			new AlertWindow(AlertType.ATTENTION, "Veuillez sélectionner une compétence");
		else {
			if (button.getText().equals("Supprimer")) {
				getJDialogCompetenceActivite().getCompIntsSelect().remove(getCompIntSelected());

				List<Savoir> savoirsAut = new ArrayList<Savoir>();

				for (CompetenceIntermediaire compInt : getJDialogCompetenceActivite().getCompIntsSelect()) {
					for (Savoir savoir : compInt.getCompetence().getSavoirs()) {
						savoirsAut.add(savoir);
					}
				}

				for (SavoirAssocie savAss : getJDialogCompetenceActivite().getSavoirAssocieSelected()) {
					if (savoirsAut.isEmpty())
						getJDialogCompetenceActivite().setSavoirAssocieSelected(new ArrayList<SavoirAssocie>());
					else {
						if (!savoirsAut.contains(savAss.getSavoir()))
							getJDialogCompetenceActivite().getSavoirAssocieSelected().remove(savAss);
					}
				}

				affiche();

			}
		}

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
		return getJDialogCompetenceActivite().getCompIntsSelect();
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
	protected void setButtons(List<JButton> buttons) {
		buttons.add(new JButton("Supprimer"));

		this.buttons = buttons;

	}

}
