package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class ActionVisible extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionVisible() {
		super();
		putValue(NAME, getName());
		if (sequenceVersion == null)
			setEnabled(false);
	}

	public void setSequenceVersion(SequenceVersion sequence) {
		if (!sequence.isVisible() && Connect.getPConnexion().getUser().getAuteur() == sequence.getAuteur())
			setEnabled(true);
		this.sequenceVersion = sequence;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		sequenceVersion.setVisible(true);

		MainFrame.getUniqInstance().getMainOnglet().getOngletSequence().getSequencePanel().getsequencePanelVersion()
				.affiche();
		setEnabled(false);

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Rendre visible";
	}

}
