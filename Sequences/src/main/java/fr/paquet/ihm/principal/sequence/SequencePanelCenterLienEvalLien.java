package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class SequencePanelCenterLienEvalLien extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenterLienEval sequencePanelCenterLienEval = null;

	public SequencePanelCenterLienEvalLien(SequencePanelCenterLienEval sequencePanelCenterLieneval)
			throws BadLocationException {
		this(null, sequencePanelCenterLieneval);

	}

	public SequencePanelCenterLienEvalLien(String text, SequencePanelCenterLienEval sequencePanelCenterLieneval)
			throws BadLocationException {
		super(text, "Liens avec les autres disciplines", StyleTextDocument.SAISI.getStyleText());

		// setteur des componenent
		setSequencePanelCenterLienEval(sequencePanelCenterLieneval);
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
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				MainFrame.getUniqInstance().getSequenceVersion().setLien(getTextPane().getText());

	}

}
