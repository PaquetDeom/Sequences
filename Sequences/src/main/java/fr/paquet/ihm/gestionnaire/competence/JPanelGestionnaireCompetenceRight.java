package fr.paquet.ihm.gestionnaire.competence;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.ihm.commun.gestionnaire.JPanelGestionnaireRight;
import fr.paquet.ihm.commun.gestionnaire.PanelLeftRight;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;

import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Condition;
import fr.paquet.referentiel.CritereEvaluation;

public class JPanelGestionnaireCompetenceRight extends JPanelGestionnaireRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelGestionnaireCompetenceRight(JDialogCompetence jDialogCompetence) {
		super(jDialogCompetence, "Ajouter");

		// listener
		JDialogCompetence jD = (JDialogCompetence) getjDialogGestion();
		jD.getJtreGestionnaire().addSelectionListeners(this);
	}

	private CompetenceIntermediaire compInt = null;

	private void setCompetenIntermediaire(CompetenceIntermediaire compInt) {
		this.compInt = compInt;
	}

	private CompetenceIntermediaire getCompetenceIntermediaire() {
		return compInt;
	}

	@Override
	protected void setPanelTitre(String Titre) {

		JPanel panel = new JPanel(new BorderLayout());

		JLabel label = new JLabel();
		label.setFont(StyleFont.TITLECORPS.getFont());

		if (Titre != null)
			Titre = getCompetenceIntermediaire().toString();
		else
			Titre = "attente de sélection";

		label.setText(Titre);
		panel.add(label, BorderLayout.CENTER);
		panel.setBackground(StyleColor.PANELTITLE.getColor());
		panel.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());

		this.panelTitre = panel;
	}

	@Override
	protected void setPanelLeft(Object object) {
		String title = "conditions";
		String text = "attente de selection";

		if (object != null) {
			CompetenceIntermediaire compInt = (CompetenceIntermediaire) object;
			List<Condition> conditions = compInt.getConditions();
			int i = 0;

			for (Condition cond : conditions) {
				if (i == 0)
					text = cond.getCondition() + " ";
				else
					text = text.concat(cond.getCondition()) + " ";
				i++;
			}

		}

		PanelLeftRight panel = new PanelLeftRight(text, title);
		this.panelLeft = panel;
	}

	@Override
	protected void setPanelRight(Object object) {
		String title = "critères d'évaluation";
		String text = "attente de selection";

		if (object != null) {
			CompetenceIntermediaire compInt = (CompetenceIntermediaire) object;
			List<CritereEvaluation> critereEvaluations = compInt.getCritereEvaluations();
			int i = 0;

			for (CritereEvaluation crit : critereEvaluations) {
				if (i == 0)
					text = crit.getCritere() + " ";
				else
					text = text.concat(crit.getCritere()) + " ";
				i++;
			}

		}

		PanelLeftRight panel = new PanelLeftRight(text, title);
		this.panelRight = panel;
	}

	@Override
	public void SelectionChange(SelectedEvent eventObject) {
		UserObject userObject = (UserObject) eventObject.getObject();
		CompetenceIntermediaire compInt = (CompetenceIntermediaire) userObject.getObject();
		setCompetenIntermediaire(compInt);
		setPanelTitre(compInt.getIntitule());
		setPanelLeft(compInt);
		setPanelRight(compInt);

		affiche();

	}

}
