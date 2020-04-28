package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.sequence.SequenceVersion;

public class ActionActivite extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionActivite() {
		super();
		putValue(NAME, getName());
		if (sequenceVersion == null)
			setEnabled(false);

	}

	public void setSequenceVersion(SequenceVersion sequenceVersion) {
		this.sequenceVersion = sequenceVersion;
		Enable();
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
		if (sequenceVersion != null && sequenceVersion.isModifiable(Connect.getPConnexion().getUser().getAuteur()))
			setEnabled(true);
		else
			setEnabled(false);
	}

}
