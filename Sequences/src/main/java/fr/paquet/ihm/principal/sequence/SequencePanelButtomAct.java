package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Scrollable;

import fr.paquet.ihm.commun.CommunStyle;
import fr.paquet.ihm.commun.Title;

public class SequencePanelButtomAct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelButtomActTitre sequencePanelButtomActTitre = null;
	private List<SequencePanelButtomActJLabel> sequencePanelButtomActJLabel = null;
	private SequencePanelButtomActButton sequencePanelButtomActButton = null;

	public SequencePanelButtomAct(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);
		setSequencePanelButtomActTitre(new SequencePanelButtomActTitre(Title.ACTIVITES, this));
		setSequencePanelButtomActButton(
				new SequencePanelButtomActButton("+ Activité", Title.ACTIVITES.getcolumn(), this));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage
		add(getSequencePanelButtomActTitre(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		affiche();

		// Attribut du panel
		setBorder(CommunStyle.BORDER.getBorder());

	}

	public void affiche() {

		int rows = 1;

		if (!getSequencePanelButtomActJLabel().isEmpty()) {
			for (SequencePanelButtomActJLabel a : getSequencePanelButtomActJLabel()) {

				add(a, new GridBagConstraints(rows, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 5, 0), 0, 0));
				rows++;

			}
		}

		add(getSequencePanelButtomActButton(), new GridBagConstraints(rows, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		this.revalidate();
	}

	private List<SequencePanelButtomActJLabel> getSequencePanelButtomActJLabel() {
		if (sequencePanelButtomActJLabel == null)
			sequencePanelButtomActJLabel = new ArrayList<SequencePanelButtomActJLabel>();
		return sequencePanelButtomActJLabel;
	}

	public void addSequencePanelButtomActJLabel(SequencePanelButtomActJLabel sequencePanelButtomActJLabel) {
		getSequencePanelButtomActJLabel().add(sequencePanelButtomActJLabel);
	}

	private void setSequencePanelButtomActJLabels(List<SequencePanelButtomActJLabel> sequencePanelButtomActJLabels) {
		this.sequencePanelButtomActJLabel = sequencePanelButtomActJLabels;
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

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

}