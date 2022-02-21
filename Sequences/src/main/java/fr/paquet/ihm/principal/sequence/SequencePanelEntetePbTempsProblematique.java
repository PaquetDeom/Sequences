package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class SequencePanelEntetePbTempsProblematique extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;

	public SequencePanelEntetePbTempsProblematique(SequencePanelEntetePbTemps sequencePanelEntetePbTemps)
			throws BadLocationException {
		this(null, sequencePanelEntetePbTemps);

	}

	public SequencePanelEntetePbTempsProblematique(String text, SequencePanelEntetePbTemps sequencePanelEntetePbTemps)
			throws BadLocationException {
		super(text, "Problématique", StyleTextDocument.SAISI.getStyleText());

		// setteur
		setSequencePanelEntetePbTemps(sequencePanelEntetePbTemps);
	}

	public SequencePanelEntetePbTemps getSequencePanelEntetePbTemps() {
		return sequencePanelEntetePbTemps;
	}

	public void setSequencePanelEntetePbTemps(SequencePanelEntetePbTemps sequencePanelEntetePbTemps) {
		this.sequencePanelEntetePbTemps = sequencePanelEntetePbTemps;
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Editable();

	}

	@Override
	protected void Editable() {
		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable())
			getTextPane().setEditable(true);
		else
			getTextPane().setEditable(false);
	}

	@Override
	protected void setJTextPaneSize(Dimension dimensionTextPane) {
		this.dimensionTextPane = new Dimension(0, getPreferredSize().height * 12);

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable())
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				MainFrame.getUniqInstance().getSequenceVersion().setProblematique(getTextPane().getText());

	}

}
