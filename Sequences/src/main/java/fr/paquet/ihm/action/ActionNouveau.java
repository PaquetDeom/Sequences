package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.KeyStroke;

import fr.paquet.ihm.nouveau.JDialogNewSequence;
import fr.paquet.sequence.Sequence;;

public class ActionNouveau extends ActionBDA {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionNouveau() {
		super();
		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JDialogNewSequence fNS = new JDialogNewSequence("Nouvelle Séquence", "Titre de la Séquence");
		fNS.setVisible(true);

	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Nouveau";
	}

}
