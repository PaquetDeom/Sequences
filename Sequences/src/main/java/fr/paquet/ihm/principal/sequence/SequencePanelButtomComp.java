package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelButtomComp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelButtomComp(SequencePanel sequencePanel) throws Exception {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage

		add(getSequencePanelButtomCompTitre(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompJPanelJlabel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompButton(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private SequencePanelButtomCompJPanelJlabel sequencePanelButtomCompJPanelJlabel = null;

	public SequencePanelButtomCompJPanelJlabel getSequencePanelButtomCompJPanelJlabel() {
		if (sequencePanelButtomCompJPanelJlabel == null)
			sequencePanelButtomCompJPanelJlabel = new SequencePanelButtomCompJPanelJlabel(this);
		return sequencePanelButtomCompJPanelJlabel;
	}

	private SequencePanelButtomCompTitre sequencePanelButtomCompTitre = null;

	private SequencePanelButtomCompTitre getSequencePanelButtomCompTitre() throws Exception {
		if (sequencePanelButtomCompTitre == null)
			sequencePanelButtomCompTitre = new SequencePanelButtomCompTitre(Title.COMPETENCES, this);
		return sequencePanelButtomCompTitre;
	}

	private SequencePanelButtomCompButton sequencePanelButtomCompButton = null;

	private SequencePanelButtomCompButton getSequencePanelButtomCompButton() throws Exception {
		if (sequencePanelButtomCompButton == null)
			sequencePanelButtomCompButton = new SequencePanelButtomCompButton("+ Compétence",
					Title.COMPETENCES.getcolumn(), this);
		return sequencePanelButtomCompButton;
	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	public void addCompetence() throws Exception {
		getSequencePanelButtomCompJPanelJlabel().addCompetence();

	}

}
