package fr.paquet.ihm.action;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.nouveau.JDialogNewSequence;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class ActionNouveau extends ActionBDA implements AlertListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionNouveau() {
		super();

		putValue(NAME, getName());
		putValue(ACCELERATOR_KEY,
				KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
		MainFrame.getUniqInstance().addPropertyChangeListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			if (getSequenceVersion() == null)
				new JDialogNewSequence();
			else {
				CompareSequenceWithDB compare = new CompareSequenceWithDB(getSequenceVersion());
				if (!compare.isSame()
						&& getSequenceVersion().isModifiable(Connect.getPConnexion().getUser().getAuteur()))
					new AlertWindow(AlertType.QUESTION, "Voulez vous enregistrer la séquence", this);
				else
					new JDialogNewSequence();
			}

		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Erreur lors du chargement de la fenêtre");
			e.printStackTrace();
		}

	}

	@Override
	public String getParentMenuName() {
		return "Fichier";
	}

	@Override
	public String getName() {

		return "Nouveau";
	}

	@Override
	protected void Enable() {

	}

	private SequenceVersion getSequenceVersion() {

		return MainFrame.getUniqInstance().getSequenceVersion();

	}

	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui"))
			try {
				new SequenceVersionFactory().persist(getSequenceVersion());
			} catch (Exception e) {
				new AlertWindow(AlertType.ERREUR, "La séquence n'a pas été sauvegardée");
				e.printStackTrace();
			}
		try {
			new JDialogNewSequence();
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "La séquence n'a pas été crée");
			e.printStackTrace();
		}

	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

	@Override
	public JMenuItem getJMenuItem() {
		JMenuItem mItem = new JMenuItem(this);

		mItem.setIcon(new ImageIcon("./target/classes/images/icons/new.png"));
		return mItem;
	}

}
