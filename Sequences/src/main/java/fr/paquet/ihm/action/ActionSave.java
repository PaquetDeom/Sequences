package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.sequence.Sequence;
import fr.paquet.sequence.SequenceFactory;

public class ActionSave extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sequence sequence = null;

	public ActionSave() {
		super();

		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			SequenceFactory pF = new SequenceFactory();
			pF.save(getSequence());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	private Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) throws Exception {
		if(sequence == null)
			throw new Exception("Veuillez renseigner une séquence");
		this.sequence = sequence;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Sauver";
	}

}
