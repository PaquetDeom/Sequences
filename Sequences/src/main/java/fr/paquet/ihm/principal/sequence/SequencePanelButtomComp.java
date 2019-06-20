package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.Title;

public class SequencePanelButtomComp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelButtomCompTitre sequencePanelButtomCompTitre = null;
	private List<SequencePanelButtomCompJLabel> sequencePanelButtomCompJLabel = null;
	private SequencePanelButtomCompButton sequencePanelButtomCompButton = null;

	public SequencePanelButtomComp(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);
		setSequencePanelButtomCompTitre(new SequencePanelButtomCompTitre(Title.COMPETENCES, this));
		setSequencePanelButtomCompButton(
				new SequencePanelButtomCompButton("+ Compétence", Title.COMPETENCES.getcolumn(), this));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage
		add(getSequencePanelButtomCompTitre(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		affiche();

		// Attribut du panel

	}

	public void affiche() {

		int rows = 1;

		if (!getSequencePanelButtomCompJLabel().isEmpty()) {
			for (SequencePanelButtomCompJLabel a : getSequencePanelButtomCompJLabel()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		add(getSequencePanelButtomCompButton(), new GridBagConstraints(0, rows, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

		this.revalidate();
	}

	private List<SequencePanelButtomCompJLabel> getSequencePanelButtomCompJLabel() {
		if (sequencePanelButtomCompJLabel == null)
			sequencePanelButtomCompJLabel = new ArrayList<SequencePanelButtomCompJLabel>();
		return sequencePanelButtomCompJLabel;
	}

	public void addSequencePanelButtomCompJLabel(SequencePanelButtomCompJLabel sequencePanelButtomCompJLabel) {
		getSequencePanelButtomCompJLabel().add(sequencePanelButtomCompJLabel);
	}

	private void setSequencePanelButtomCompJLabels(List<SequencePanelButtomCompJLabel> sequencePanelButtomCompJLabels) {
		this.sequencePanelButtomCompJLabel = sequencePanelButtomCompJLabels;
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
