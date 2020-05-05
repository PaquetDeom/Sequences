package fr.paquet.ihm.gestionnaire.activite.competence;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.gestionnaire.competence.JPanelGestionnaireCompetenceRight;
import fr.paquet.ihm.principal.activite.ActivitePanel;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.SequenceVersion;

public class JDialogCompetenceActivite extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	@SuppressWarnings("unchecked")
	public JDialogCompetenceActivite(Activite_1 activite, ActivitePanel activitePanel) {
		super("Gestion des compétences de l'activité", activite);

		setActivitePanel(activitePanel);

		if (!getActivite().getCompetencesIntermediaires().isEmpty()) {
			compIntsSelect = (ArrayList<CompetenceIntermediaire>) ((ArrayList<CompetenceIntermediaire>) getActivite()
					.getCompetencesIntermediaires()).clone();
			setButtomPanel();
			affiche();
			if (!getActivite().getSavoirAssocies().isEmpty())
				setSavoirAssocieSelected(
						(ArrayList<SavoirAssocie>) ((ArrayList<SavoirAssocie>) getActivite().getSavoirAssocies())
								.clone());

		}

		affiche();
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
			getActivite().setCompetencesIntermédiaires(getCompIntsSelect());
			getActivite().setSavoirAssocies(getSavoirAssocieSelected());

			// affiche les composants
			getActivitePanel().getActivitePanelCompetencesSavoirs().getActiviteJPanelJlabel().affiche();

			this.dispose();
		}

		if (button.getText().equals("Annuler"))
			this.dispose();

	}

	private List<SavoirAssocie> savAssSelect = new ArrayList<SavoirAssocie>();

	public List<SavoirAssocie> getSavoirAssocieSelected() {
		return savAssSelect;
	}

	public void setSavoirAssocieSelected(List<SavoirAssocie> savoirAssocies) {
		this.savAssSelect = savoirAssocies;
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

	private SequenceVersion getSequenceVersion() {

		return getActivite().getSequenceVersion();
	}

	public Activite_1 getActivite() {
		return (Activite_1) getObject();
	}

	@SuppressWarnings("unchecked")
	private List<CompetenceIntermediaire> getCompetenceIntermediaires() throws Exception {

		if (getSequenceVersion().getCompetenceIntermediaires().isEmpty())
			throw new Exception("Construction de la fenêtre impossible");
		List<CompetenceIntermediaire> compInts = (ArrayList<CompetenceIntermediaire>) ((ArrayList<CompetenceIntermediaire>) getSequenceVersion()
				.getCompetenceIntermediaires()).clone();

		return compInts;
	}

	@Override
	protected void setJtreeGestionnaire() {
		JtreeGestionnaireCompetenceActivite jtreeGestionnaire = null;
		try {
			jtreeGestionnaire = new JtreeGestionnaireCompetenceActivite(getCompetenceIntermediaires());
			this.jtreeGestionnaire = jtreeGestionnaire;
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	protected void setJPanelGestionnaireRight() {
		JPanelGestionnaireCompetenceRight panel = new JPanelGestionnaireCompetenceRight(this);
		this.jPanelGestionnaireRight = panel;

	}

	@Override
	protected void setButtomPanel() {
		this.buttomPanel = new ButtomPanelCompetenceActivite(this);

	}

	private ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

	@Override
	protected void addButton() {

		JButton buttonOui = new JButton("Oui");
		buttonOui.addActionListener(this);

		JButton buttonAnnuler = new JButton("Annuler");
		buttonAnnuler.addActionListener(this);

		getButtons().add(buttonOui);
		getButtons().add(buttonAnnuler);

	}

}
