package fr.paquet.ihm.commun;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.style.StyleTextDocument;
import fr.paquet.referentiel.SavoirAssocie;

public class JPanelSavoir extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTableCompetences jTableCompetences = null;

	public JPanelSavoir(JTableCompetences jTableCompetences) throws BadLocationException {
		super(null, "Savoirs associes", null);

		// set des composants
		setjTableCompetences(jTableCompetences);

		// insertion du text
		insertText();
	}

	private void insertText() throws BadLocationException {

		int pos = 0;

		if (getjTableCompetences().getSavoirAssocies() != null && !getjTableCompetences().getSavoirAssocies().isEmpty())

			for (SavoirAssocie sav : getjTableCompetences().getSavoirAssocies()) {

				getTextPane().getStyledDocument().insertString(pos, sav.toString() + "\n",
						StyleTextDocument.COMPETENCE.getStyleText());
				pos = pos + getTextPane().getStyledDocument().getLength();
			}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

	}

	@Override
	public void focusGained(FocusEvent event) {

	}

	@Override
	public void focusLost(FocusEvent event) {

	}

	@Override
	protected void Editable() {
		getTextPane().setEditable(false);

	}

	@Override
	protected void setJTextPaneSize(Dimension dimensionTextPane) {

	}

	public JTableCompetences getjTableCompetences() {
		return jTableCompetences;
	}

	private void setjTableCompetences(JTableCompetences jTableCompetences) {
		this.jTableCompetences = jTableCompetences;
	}

}
