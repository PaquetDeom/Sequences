package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class SequencePanelCenterLienEvalEval extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	public SequencePanelCenterLienEvalEval(SequencePanelCenterLienEval sequencePanelCenterLienEval)
			throws BadLocationException {
		this(null, sequencePanelCenterLienEval);

	}

	public SequencePanelCenterLienEvalEval(String text, SequencePanelCenterLienEval sequencePanelCenterLienEval)
			throws BadLocationException {
		super(text, "Modalité d'évaluation", StyleTextDocument.SAISI.getStyleText());

		// setteur des components
		setSequencePanelCenterLienEval(sequencePanelCenterLienEval);

	}

	public SequencePanelCenterLienEval getSequencePanelCenterLienEval() {
		return sequencePanelCenterLienEval;
	}

	private void setSequencePanelCenterLienEval(SequencePanelCenterLienEval sequencePanelCenterLienEval) {
		this.sequencePanelCenterLienEval = sequencePanelCenterLienEval;
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
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable())
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				MainFrame.getUniqInstance().getSequenceVersion().setEval(getTextPane().getText());

	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

}
