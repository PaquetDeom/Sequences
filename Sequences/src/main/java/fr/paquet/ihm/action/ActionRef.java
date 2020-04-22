package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.KeyStroke;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.SequenceVersion;

public class ActionRef extends ActionBDA {

	/**
	 * @author paquet
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersion = null;

	public ActionRef() {
		super();

		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('D', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Runtime.getRuntime().exec(getUrl());
		} catch (IOException e) {
			new AlertWindow(AlertType.ERREUR, "Firefox n'est pas installé sur l'ordinateur");
			e.printStackTrace(System.out);
		}

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	private String getUrl() {
		return "firefox " + getSequenceVersion().getReferentiel().getUrl();
	}

	public void setSequenceVersion(SequenceVersion SequenceVersion) throws Exception {
		if (SequenceVersion == null)
			throw new Exception("Veuillez renseigner une séquence");
		this.sequenceVersion = SequenceVersion;
	}

	private SequenceVersion getSequenceVersion() {
		return sequenceVersion;
	}

	@Override
	public String getName() {

		return "Referentiel";
	}

}
