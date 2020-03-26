package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelButtomAct extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelButtomAct(SequencePanel sequencePanel) throws Exception {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage
		add(getSequencePanelButtomActTitre(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomActJPanelJLabel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomActButton(), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private SequencePanelButtomActButton sequencePanelButtomActButton = null;

	private SequencePanelButtomActButton getSequencePanelButtomActButton() throws Exception {
		if (sequencePanelButtomActButton == null)
			sequencePanelButtomActButton = new SequencePanelButtomActButton("+ Activité", Title.ACTIVITES.getcolumn(),
					this);
		return sequencePanelButtomActButton;
	}

	private SequencePanelButtomActTitre sequencePanelButtomActTitre = null;

	private SequencePanelButtomActTitre getSequencePanelButtomActTitre() throws Exception {
		if (sequencePanelButtomActTitre == null)
			sequencePanelButtomActTitre = new SequencePanelButtomActTitre(Title.ACTIVITES, this);
		return sequencePanelButtomActTitre;
	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	private SequencePanelButtomActJPanelJLabel sequencePanelButtomActJPanelJLabel = null;

	public SequencePanelButtomActJPanelJLabel getSequencePanelButtomActJPanelJLabel() {
		if (sequencePanelButtomActJPanelJLabel == null) {
			sequencePanelButtomActJPanelJLabel = new SequencePanelButtomActJPanelJLabel(this);
		}
		return sequencePanelButtomActJPanelJLabel;
	}

	public void addActivite() throws Exception {
		getSequencePanelButtomActJPanelJLabel().addActivite();
	}

}