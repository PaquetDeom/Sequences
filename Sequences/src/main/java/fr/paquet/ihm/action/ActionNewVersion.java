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
		setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {

		this.sequence = sequence;
		Enable();
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

	@Override
	protected void Enable() {
		if (sequence != null)
			setEnabled(true);
		else
			setEnabled(false);

	}

}
