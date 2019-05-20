package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.sequence.Sequence;

public class ActionOuvrir extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sequence sequence = null;

	public ActionOuvrir(Sequence sequence) throws Exception {
		super();
		setSequence(sequence);
		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	private Sequence getSequence() {
		return sequence;
	}

	private void setSequence(Sequence sequence) throws Exception {
		if (sequence == null)
			throw new Exception("Veuillez séletionner un sequence");
		this.sequence = sequence;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Ouvrir";
	}

}
