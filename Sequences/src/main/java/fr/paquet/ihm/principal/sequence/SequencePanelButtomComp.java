package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.CommunStyle;
import fr.paquet.ihm.commun.Title;

public class SequencePanelButtomComp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelButtomCompTitre sequencePanelButtomCompTitre = null;
	private SequencePanelButtomCompButton sequencePanelButtomCompButton = null;
	private SequencePanelButtomCompJPanelJLabel sequencePanelButtomCompJPanelJLabel = null;

	public SequencePanelButtomComp(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);
		setSequencePanelButtomCompTitre(new SequencePanelButtomCompTitre(Title.COMPETENCES, this));
		setSequencePanelButtomCompJPanelJLabel(new SequencePanelButtomCompJPanelJLabel(this));
		setSequencePanelButtomCompButton(
				new SequencePanelButtomCompButton("+ Compétence", Title.COMPETENCES.getcolumn(), this));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage
		add(getSequencePanelButtomCompTitre(), new GridBagConstraints(0, 0, 1, 1, 1, 0.0, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompJPanelJLabel(), new GridBagConstraints(0, 1, 1, 1, 1, 1,
				GridBagConstraints.PAGE_START, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompButton(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(CommunStyle.BORDER.getBorder());

	}

	private void setSequencePanelButtomCompJPanelJLabel(
			SequencePanelButtomCompJPanelJLabel sequencePanelButtomCompJPanelJLabel) {

		this.sequencePanelButtomCompJPanelJLabel = sequencePanelButtomCompJPanelJLabel;
	}

	public SequencePanelButtomCompJPanelJLabel getSequencePanelButtomCompJPanelJLabel() {
		return sequencePanelButtomCompJPanelJLabel;
	}

	private SequencePanelButtomCompButton getSequencePanelButtomCompButton() {
		return sequencePanelButtomCompButton;
	}

	private void setSequencePanelButtomCompButton(SequencePanelButtomCompButton sequencePanelButtomCompButton) {
		this.sequencePanelButtomCompButton = sequencePanelButtomCompButton;
	}

	private SequencePanelButtomCompTitre getSequencePanelButtomCompTitre() {
		return sequencePanelButtomCompTitre;
	}

	private void setSequencePanelButtomCompTitre(SequencePanelButtomCompTitre sequencePanelButtomCompTitre) {
		this.sequencePanelButtomCompTitre = sequencePanelButtomCompTitre;
	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

}
