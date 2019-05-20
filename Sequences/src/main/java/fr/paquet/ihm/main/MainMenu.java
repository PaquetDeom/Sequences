package fr.paquet.ihm.main;

import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.ihm.action.*;
import fr.paquet.sequence.Sequence;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	/**
	 * @author Nathanaël
	 */

	private ActionSave actionSave = null;
	private ActionRef actionRef = null;
	private static MainMenu mainMenu = null;
	private Sequence sequence = null;
	private ActionOuvrir actionOuvrir = null;

	/**
	 * Constructeur de la class ajoute les Action a MainMenu<br/>
	 * 
	 * @throws Exception
	 */
	private MainMenu() throws Exception {

		addAction(new ActionNouveau());
		setActionOuvrir(new ActionOuvrir(getSequence()));
		addAction(getActionOuvrir(getSequence()));
		addAction(new ActionQuitter());
		setActionRef(new ActionRef(getSequence()));
		addAction(getActionRef(getSequence()));
		setActionSave(new ActionSave());
		addAction(getActionSave());

	}

	private ActionBDA getActionRef(Sequence sequence) {
		// TODO Auto-generated method stub
		return actionRef;
	}

	private void setActionRef(ActionRef actionRef) {
		this.actionRef = actionRef;
	}

	private void setActionOuvrir(ActionOuvrir actionOuvrir) {
		this.actionOuvrir = actionOuvrir;
	}

	private ActionOuvrir getActionOuvrir(Sequence sequence) {
		return actionOuvrir;
	}

	public static MainMenu getUniqInstance() throws Exception {
		if (mainMenu == null)
			mainMenu = new MainMenu();
		return mainMenu;
	}

	private Hashtable<String, JMenu> menus = new Hashtable<String, JMenu>();

	private JMenu getJMenu(String menuName) {
		JMenu menu = menus.get(menuName);
		if (menu == null) {
			menus.put(menuName, menu = new JMenu(menuName));
			super.add(menu);
		}
		return menu;
	}

	public ActionBDA addAction(ActionBDA action) {

		// créé un nouveau JMenu
		JMenuItem jMenuAction = new JMenuItem(action);

		getJMenu(action.getParentMenuName()).add(jMenuAction);
		return action;
	}

	public ActionSave getActionSave() {
		return actionSave;
	}

	public void setActionSave(ActionSave actionSave) {
		this.actionSave = actionSave;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}
}
