package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.sequence.SequenceVersion;

public class ActionNewVersion extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequence = null;

	public ActionNewVersion() {
		super();
		putValue(NAME, getName());
		if (sequence == null)
			setEnabled(false);
	}

	public void setSequence(SequenceVersion sequence) {
		if (sequence != null)
			setEnabled(true);
		this.sequence = sequence;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new SequenceVersion(sequence);

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Créer une nouvelle version";
	}

}
