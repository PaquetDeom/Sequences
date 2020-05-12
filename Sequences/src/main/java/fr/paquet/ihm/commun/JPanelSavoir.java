package fr.paquet.ihm.commun;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.style.StyleTextDocument;

public class JPanelSavoir extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTableCompetences jTableCompetences = null;

	public JPanelSavoir(JTableCompetences jTableCompetences) throws BadLocationException {
		this(null, jTableCompetences);

	}

	public JPanelSavoir(String text, JTableCompetences jTableCompetences) throws BadLocationException {
		super(text, "Savoirs associes", StyleTextDocument.COMPETENCE.getStyleText());

		// set des composants
		setjTableCompetences(jTableCompetences);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

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
