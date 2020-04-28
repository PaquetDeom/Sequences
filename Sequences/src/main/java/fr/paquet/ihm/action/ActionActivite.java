package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import fr.paquet.dataBase.Connect;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class ActionActivite extends ActionBDA implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionActivite() {
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
		// TODO Auto-generated method stub

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Gestion ativites";
	}

	@Override
	protected void Enable() {
		if (getSequenceVersion() != null) {
			if (getSequenceVersion().isModifiable(Connect.getPConnexion().getUser().getAuteur()))
				setEnabled(true);
			else
				setEnabled(false);
		} else
			setEnabled(false);

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

}
