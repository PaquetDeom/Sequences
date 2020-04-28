package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import fr.paquet.ihm.nouveau.JDialogNewVersion;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;
import main.MainMenu;

public class ActionNewVersion extends ActionBDA implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionNewVersion(MainMenu mainMenu) {
		super();

		putValue(NAME, getName());
		MainFrame.getUniqInstance().addPropertyChangeListener(this);
		Enable();
	}

	private SequenceVersion getSequenceVersion() {

		return MainFrame.getUniqInstance().getSequenceVersion();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new JDialogNewVersion(getSequenceVersion());

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
		if (getSequenceVersion() != null)
			setEnabled(true);
		else
			setEnabled(false);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

}
