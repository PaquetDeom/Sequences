package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.text.BadLocationException;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.commun.CommunJLabelJTextPaneVertical;
import main.MainFrame;

public class SequencePanelCenterPrésentation extends CommunJLabelJTextPaneVertical {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SequencePanelCenterPrésentation(SequencePanelCenter sequencePanelCenter)
			throws BadLocationException {
		super(null, "Présentation du contexte professionnel", null);

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
				MainFrame.getUniqInstance().getSequenceVersion().setContexte(getTextPane().getText());

	}

}
