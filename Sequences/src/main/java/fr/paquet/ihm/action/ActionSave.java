package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.sequence.SequenceVersion;

public class ActionSave extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionSave() {
		super();

		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

		setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			SequenceVersionFactory pF = new SequenceVersionFactory();
			pF.persist(getSequenceVersion());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getParentMenuName() {

		return "Fichier";
	}

	private SequenceVersion getSequenceVersion() {
		return sequenceVersion;
	}

	public void setSequenceVersion(SequenceVersion sequenceVersion) throws Exception {
		if (sequenceVersion == null)
			throw new Exception("Veuillez renseigner une séquence");
		else {
			setEnabled(true);
			this.sequenceVersion = sequenceVersion;
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Sauver";
	}

}
