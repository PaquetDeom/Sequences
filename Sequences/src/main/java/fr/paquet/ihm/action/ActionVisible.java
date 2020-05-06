package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;
import main.MainOnglet;

public class ActionVisible extends ActionBDA implements AlertListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionVisible() {
		super();
		putValue(NAME, getName());
		MainFrame.getUniqInstance().addPropertyChangeListener(this);
		Enable();
	}

	private SequenceVersion getSequenceVersion() {

		return MainFrame.getUniqInstance().getSequenceVersion();

	}

	public void Enable() {
		if (getSequenceVersion() != null) {
			if (!getSequenceVersion().isVisible()
					&& Connect.getPConnexion().getUser().getAuteur() == getSequenceVersion().getAuteur())
				setEnabled(true);
			else
				setEnabled(false);
		} else
			setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		new AlertWindow(AlertType.QUESTION, "Après cette opération vous ne pourrez plus modifier cette séquence", this);
		MainOnglet.getUniqInstance().afficheVersion();
		Enable();

	}

	@Override
	public String getParentMenuName() {

		return "Outils";
	}

	@Override
	public String getName() {

		return "Rendre visible";
	}

	@Override
	public void buttonClick(String button) {

		if (button.equals("Oui")) {
			getSequenceVersion().setVisible(true);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		Enable();

	}

	@Override
	public JMenuItem getJMenuItem() {
		JMenuItem mItem = new JMenuItem(this);

		return mItem;
	}

}
