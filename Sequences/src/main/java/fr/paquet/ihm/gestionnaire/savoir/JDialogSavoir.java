package fr.paquet.ihm.gestionnaire.savoir;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.gestionnaire.competence.JDialogCompetence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.SequenceVersion;

public class JDialogSavoir extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogCompetence jDialogCompetence = null;

	@SuppressWarnings("unchecked")
	public JDialogSavoir(CompetenceIntermediaire competenceIntermediaire, SequenceVersion sequence,
			JDialogCompetence jDialogCompetence) {
		super("Gestionnaire des savoirs de : " + competenceIntermediaire.toString(), competenceIntermediaire);

		setjDialogCompetence(jDialogCompetence);

		if (!getjDialogCompetence().getSavoirAssocieSelected().isEmpty()) {

			savAssSelect = (List<SavoirAssocie>) ((ArrayList<SavoirAssocie>) getjDialogCompetence()
					.getSavoirAssocieSelected()).clone();

			setButtomPanel();

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

			SavoirAssocie savAss = (SavoirAssocie) getJPanelGestionnaireRight().getObjectSelected();

			try {
				addSavoirAssocie(savAss);
			} catch (Exception e) {
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}

			getJButtomPanel().affiche();

		}

		if (button.getText().equals("Valider")) {
			getjDialogCompetence().setSavoirAssocieSelected(getSavAssSelect());
			dispose();
		}

		if (button.getText().equals("Annuler"))
			this.dispose();

	}

	private void addSavoirAssocie(SavoirAssocie savoirAssocie) throws Exception {
		if (!getSavAssSelect().contains(savoirAssocie))
			getSavAssSelect().add(savoirAssocie);
		else
			throw new Exception("Le savoir est déja dans la liste");
	}

	private CompetenceIntermediaire getCompetenceIntermediaire() {
		return (CompetenceIntermediaire) getObject();
	}

	private List<Savoir> getSavoirs() {

		List<Savoir> savoirs = getCompetenceIntermediaire().getCompetence().getSavoirs();

		return savoirs;
	}

	private List<SavoirAssocie> savAssSelect = null;

	public List<SavoirAssocie> getSavAssSelect() {
		if (savAssSelect == null)
			savAssSelect = new ArrayList<SavoirAssocie>();
		return savAssSelect;

	}

	@Override
	protected void setJtreeGestionnaire() {
		JTreeGestionnaireSavoir jtreeGestionnaire = new JTreeGestionnaireSavoir(getSavoirs());
		this.jtreeGestionnaire = jtreeGestionnaire;

	}

	@Override
	protected void setJPanelGestionnaireRight() {
		JPanelGestionnaireSavoirRight panel = new JPanelGestionnaireSavoirRight(this);
		this.jPanelGestionnaireRight = panel;

	}

	@Override
	protected void setButtomPanel() {
		this.buttomPanel = new ButtomPanelSavoir(this);

	}

	private JDialogCompetence getjDialogCompetence() {
		return jDialogCompetence;
	}

	private void setjDialogCompetence(JDialogCompetence jDialogCompetence) {
		this.jDialogCompetence = jDialogCompetence;
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
