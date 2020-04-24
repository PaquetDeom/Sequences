package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.ihm.nouveau.JDialogNewVersion;
import fr.paquet.sequence.SequenceVersion;
import main.MainMenu;

public class ActionNewVersion extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequence = null;

	public ActionNewVersion(MainMenu mainMenu) {
		super();

		putValue(NAME, getName());
		if (sequence == null)
			setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {
		if (sequence != null)
			setEnabled(true);
		this.sequence = sequence;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new JDialogNewVersion(sequence);

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
