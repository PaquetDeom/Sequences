package fr.paquet.ihm.principal.activite;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class ActivitePanelContexte extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelContexte(ActivitePanel activitePanel) throws BadLocationException {
		this(null, activitePanel);

	}

	public ActivitePanelContexte(String text, ActivitePanel activitePanel) throws BadLocationException {
		super(text, "Contexte professionnel", StyleTextDocument.SAISI.getStyleText());

		// set des composants
		setActivitepanel(activitePanel);
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;

	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
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
		this.dimensionTextPane = new Dimension(0, getPreferredSize().height * 12);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Editable();

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				getActivitepanel().getOngletActivite().getActivite().setContexte(getTextPane().getText());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

}
