package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public class SequencePanelButtomComp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelButtomComp(SequencePanel sequencePanel) throws BadLocationException {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage

		add(getSequencePanelButtomCompCompSavoir(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompButton(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private SequencePanelButtomCompCompSavoir sequencePanelButtomCompCompSavoir = null;

	public SequencePanelButtomCompCompSavoir getSequencePanelButtomCompCompSavoir() throws BadLocationException {
		if (sequencePanelButtomCompCompSavoir == null) {
			if (MainFrame.getUniqInstance().getSequenceVersion().getCompetenceIntermediaires().isEmpty())
				sequencePanelButtomCompCompSavoir = new SequencePanelButtomCompCompSavoir(this);
			else if (MainFrame.getUniqInstance().getSequenceVersion().getSavoirAssocies().isEmpty())
				sequencePanelButtomCompCompSavoir = new SequencePanelButtomCompCompSavoir(
						MainFrame.getUniqInstance().getSequenceVersion().getCompetenceIntermediaires(), null, this);
			else
				sequencePanelButtomCompCompSavoir = new SequencePanelButtomCompCompSavoir(
						MainFrame.getUniqInstance().getSequenceVersion().getCompetenceIntermediaires(),
						MainFrame.getUniqInstance().getSequenceVersion().getSavoirAssocies(), this);
		}
		return sequencePanelButtomCompCompSavoir;
	}

	private SequencePanelButtomCompButton sequencePanelButtomCompButton = null;

	private SequencePanelButtomCompButton getSequencePanelButtomCompButton() {
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
	
}
