package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class ActivitePanelConceptionQuestion extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelConception activitePanelConception = null;

	public ActivitePanelConceptionQuestion(ActivitePanelConception activitePanelConception)
			throws BadLocationException {
		this(null, activitePanelConception);

	}

	public ActivitePanelConceptionQuestion(String text, ActivitePanelConception activitePanelConception)
			throws BadLocationException {
		super(text, "Questionnement", StyleTextDocument.SAISI.getStyleText());

		// set des compposants
		setActivitePanelConception(activitePanelConception);

	}

	public ActivitePanelConception getActivitePanelConception() {
		return activitePanelConception;
	}

	private void setActivitePanelConception(ActivitePanelConception activitePanelConception) {
		this.activitePanelConception = activitePanelConception;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Editable();

	}

	@Override
	protected void Editable() {
		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			getTextPane().setEditable(true);
		else
			getTextPane().setEditable(false);
	}

	@Override
	protected void setJTextPaneSize(Dimension dimensionTextPane) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				getActivitePanelConception().getActivitepanel().getOngletActivite().getActivite()
						.setQuestionnement(getTextPane().getText());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

}
