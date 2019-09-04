package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTable;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelButtomAct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelButtomActTitre sequencePanelButtomActTitre = null;
	private SequencePanelButtomActButton sequencePanelButtomActButton = null;
	private SequencePanelButtomActJPanelJLabel sequencePanelButtomActJPanelJLabel = null;

	public SequencePanelButtomAct(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);
		setSequencePanelButtomActTitre(new SequencePanelButtomActTitre(Title.ACTIVITES, this));
		setSequencePanelButtomActJPanelJLabel(new SequencePanelButtomActJPanelJLabel(this));
		setSequencePanelButtomActButton(
				new SequencePanelButtomActButton("+ Activité", Title.ACTIVITES.getcolumn(), this));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage
		add(getSequencePanelButtomActTitre(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomActJPanelJLabel(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomActButton(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private SequencePanelButtomActButton getSequencePanelButtomActButton() {
		return sequencePanelButtomActButton;
	}

	private void setSequencePanelButtomActButton(SequencePanelButtomActButton sequencePanelButtomActButton) {
		this.sequencePanelButtomActButton = sequencePanelButtomActButton;
	}

	private SequencePanelButtomActTitre getSequencePanelButtomActTitre() {
		return sequencePanelButtomActTitre;
	}

	private void setSequencePanelButtomActTitre(SequencePanelButtomActTitre sequencePanelButtomActTitre) {
		this.sequencePanelButtomActTitre = sequencePanelButtomActTitre;
	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	public SequencePanelButtomActJPanelJLabel getSequencePanelButtomActJPanelJLabel() {
		return sequencePanelButtomActJPanelJLabel;
	}

	private void setSequencePanelButtomActJPanelJLabel(
			SequencePanelButtomActJPanelJLabel sequencePanelButtomActJPanelJLabel) {
		this.sequencePanelButtomActJPanelJLabel = sequencePanelButtomActJPanelJLabel;
	}

}