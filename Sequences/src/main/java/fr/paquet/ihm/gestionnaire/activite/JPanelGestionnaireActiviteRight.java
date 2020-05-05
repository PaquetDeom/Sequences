package fr.paquet.ihm.gestionnaire.activite;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.commun.gestionnaire.JPanelGestionnaireRight;
import fr.paquet.ihm.commun.gestionnaire.PanelLeftRight;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;
import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

public class JPanelGestionnaireActiviteRight extends JPanelGestionnaireRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelGestionnaireActiviteRight(JDialogActivte jdialogActivite) {
		super(jdialogActivite);

		// listener
		JDialogActivte jD = (JDialogActivte) getjDialogGestion();
		jD.getJtreGestionnaire().addSelectionListeners(this);
	}

	@Override
	public void SelectionChange(SelectedEvent eventObject) {
		UserObject userObject = (UserObject) eventObject.getObject();
		Activite_1 activite = (Activite_1) userObject.getObject();
		setActivite(activite);
		setPanelTitre(activite.toString());
		setPanelLeft(activite);

		affiche();

	}

	private void setActivite(Activite_1 activite) {
		this.objectSelected = activite;

	}

	@Override
	protected void setPanelLeft(Object object) {
		String title = "Activité de la séquence";
		String text = "attente de selection";

		if (object != null) {
			Activite_1 activite = (Activite_1) object;

			text = activite.getQuestionnement();

		}

		PanelLeftRight panel = new PanelLeftRight(text, title);
		this.panelLeft = panel;
	}

	@Override
	protected void setPanelRight(Object object) {
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
	protected void setButtons(List<JButton> buttons) {
		buttons.add(new JButton("Ajouter"));
		this.buttons = buttons;

	}

}
