package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.dataBase.Connect;
import fr.paquet.sequence.Sequence;
import main.MainFrame;

public class ActionVisible extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sequence sequence = null;

	public ActionVisible() {
		super();
		putValue(NAME, getName());
		if (sequence == null)
			setEnabled(false);
	}

	public void setSequence(Sequence sequence) {
		if (!sequence.isVisible() && Connect.getPConnexion().getUser().getAuteur() == sequence.getAuteur())
			setEnabled(true);
		this.sequence = sequence;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		sequence.setVisible(true);

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
