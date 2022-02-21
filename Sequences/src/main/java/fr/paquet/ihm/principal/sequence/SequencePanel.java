package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

public class SequencePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletSequence ongletSequence = null;

	public SequencePanel(OngletSequence ongletSequence) throws BadLocationException {
		super();

		// set des composants
		setOngletSequence(ongletSequence);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(getsequencePanelVersion(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new SequencePanelEntete(this), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomComp(), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new SequencePanelCenter(this), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		// add(new SequencePanelButtomAct(this), new GridBagConstraints(0, 4, 1, 1, 1.0,
		// 0.0, GridBagConstraints.CENTER,
		// GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attributs du panel

	}

	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomComp getSequencePanelButtomComp() throws BadLocationException {
		if (sequencePanelButtomComp == null)
			sequencePanelButtomComp = new SequencePanelButtomComp(this);
		return sequencePanelButtomComp;
	}

	private SequencePanelVersion sequencePanelVersion = null;

	public SequencePanelVersion getsequencePanelVersion() {
		if (sequencePanelVersion == null)
			sequencePanelVersion = new SequencePanelVersion(this);
		return sequencePanelVersion;
	}

	public OngletSequence getOngletSequence() {
		return ongletSequence;
	}

	private void setOngletSequence(OngletSequence ongletSequence) {
		this.ongletSequence = ongletSequence;
	}

}
