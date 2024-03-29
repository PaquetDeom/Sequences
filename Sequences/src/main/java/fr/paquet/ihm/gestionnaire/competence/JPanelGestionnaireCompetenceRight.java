package fr.paquet.ihm.gestionnaire.competence;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JPanelGestionnaireRight;
import fr.paquet.ihm.commun.gestionnaire.PanelLeftRight;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;

import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.ihm.gestionnaire.activite.competence.JDialogCompetenceActivite;
import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;
import fr.paquet.ihm.style.StyleTextDocument;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Condition;
import fr.paquet.referentiel.CritereEvaluation;

public class JPanelGestionnaireCompetenceRight extends JPanelGestionnaireRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelGestionnaireCompetenceRight(JDialogCompetence jDialogCompetence) {
		super(jDialogCompetence);

		// listener
		jDialogCompetence.getJtreGestionnaire().addSelectionListeners(this);
	}

	public JPanelGestionnaireCompetenceRight(JDialogCompetenceActivite jDialogCompetenceactivite) {
		super(jDialogCompetenceactivite);

		// listener
		jDialogCompetenceactivite.getJtreGestionnaire().addSelectionListeners(this);
	}

	private void setCompetenIntermediaire(CompetenceIntermediaire compInt) {
		this.objectSelected = compInt;
	}

	@Override
	protected void setPanelTitre(String Titre) {

		JPanel panel = new JPanel(new BorderLayout());

		JLabel label = new JLabel();
		label.setFont(StyleFont.TITLECORPS.getFont());

		if (Titre != null)
			label.setText(Titre);
		else
			label.setText("attente de sélection");

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

		PanelLeftRight panel;

		try {
			panel = new PanelLeftRight(text, title, StyleTextDocument.COMPETENCE.getStyleText());
			this.panelLeft = panel;
		} catch (BadLocationException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}

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

		PanelLeftRight panel;

		try {
			panel = new PanelLeftRight(text, title, StyleTextDocument.COMPETENCE.getStyleText());
			this.panelRight = panel;
		} catch (BadLocationException e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}

	}

	@Override
	public void SelectionChange(SelectedEvent eventObject) {
		UserObject userObject = (UserObject) eventObject.getObject();
		CompetenceIntermediaire compInt = (CompetenceIntermediaire) userObject.getObject();
		setCompetenIntermediaire(compInt);
		setPanelTitre(compInt.toString());
		setPanelLeft(compInt);
		setPanelRight(compInt);

		affiche();

	}

	@Override
	protected void setButtons(List<JButton> buttons) {
		buttons.add(new JButton("Ajouter"));
		this.buttons = buttons;

	}

}
