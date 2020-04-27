package fr.paquet.ihm.gestionnaire.savoir;

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
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.referentiel.SousSavoirAssocie;

public class JPanelGestionnaireSavoirRight extends JPanelGestionnaireRight {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelGestionnaireSavoirRight(JDialogSavoir jdialogSavoir) {
		super(jdialogSavoir, "Ajouter");

		// listener
		JDialogSavoir jD = (JDialogSavoir) getjDialogGestion();
		jD.getJtreGestionnaire().addSelectionListeners(this);
	}

	@Override
	public void SelectionChange(SelectedEvent eventObject) {
		UserObject userObject = (UserObject) eventObject.getObject();
		SavoirAssocie savAss = (SavoirAssocie) userObject.getObject();
		setSavoirAssocie(savAss);
		setPanelTitre(savAss.toString());
		setPanelLeft(savAss);

		affiche();

	}

	private void setSavoirAssocie(SavoirAssocie savAss) {
		this.objectSelected = savAss;

	}

	@Override
	protected void setPanelLeft(Object object) {
		String title = "Description";
		String text = "Attente de selection";

		if (object != null) {
			SavoirAssocie savAss = (SavoirAssocie) object;
			List<SousSavoirAssocie> sousSavAsss = savAss.getSousSavoirsAssocies();
			int i = 0;

			for (SousSavoirAssocie sousSavAss : sousSavAsss) {
				if (i == 0)
					text = sousSavAss.getIntitule() + " ";
				else
					text = text.concat(sousSavAss.getIntitule()) + " ";
				i++;
			}

		}

		PanelLeftRight panel = new PanelLeftRight(text, title);
		this.panelLeft = panel;

	}

	@Override
	protected void setPanelRight(Object object) {
		// TODO Auto-generated method stub

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

}
