package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import fr.paquet.ihm.style.StyleTextDocument;
import main.MainFrame;

public class SequencePanelCenterPrérequis extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenter sequencePanelCenter = null;

	public SequencePanelCenterPrérequis(SequencePanelCenter sequencePanelCenter)
			throws BadLocationException {
		this(null, sequencePanelCenter);

	}
	
	public SequencePanelCenterPrérequis(String text, SequencePanelCenter sequencePanelCenter)
			throws BadLocationException {
		super(text, "Prérequis Elèves", StyleTextDocument.SAISI.getStyleText());

		//set des composants
		setSequencePanelCenter(sequencePanelCenter);
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
		this.dimensionTextPane = new Dimension(0, dimensionTextPane.height * 12);

	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable())
			if (getTextPane().getText() != null && !getTextPane().getText().equals(""))
				MainFrame.getUniqInstance().getSequenceVersion().setPrerequis(getTextPane().getText());

	}

	public SequencePanelCenter getSequencePanelCenter() {
		return sequencePanelCenter;
	}

	private void setSequencePanelCenter(SequencePanelCenter sequencePanelCenter) {
		this.sequencePanelCenter = sequencePanelCenter;
	}

}
