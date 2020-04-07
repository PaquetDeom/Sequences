package main;

import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.ihm.action.*;

public class MainMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author Nathanaël
	 */

	private ActionSave actionSave = null;
	private ActionRef actionRef = null;
	private static MainMenu mainMenu = null;

	private ActionGestionnaire actionGestionnaire = null;

	/**
	 * Constructeur de la class ajoute les Action a MainMenu<br/>
	 * 
	 * @throws Exception
	 */
	private MainMenu() {

		addAction(new ActionNouveau());
		setActionGestionnaire(new ActionGestionnaire());
		addAction(getActionGestionnaire());
		setActionRef(new ActionRef());
		addAction(getActionRef());
		setActionSave(new ActionSave());
		addAction(getActionSave());
		addAction(new ActionQuitter());

	}

	private ActionBDA getActionRef() {
		// TODO Auto-generated method stub
		return actionRef;
	}

	private void setActionRef(ActionRef actionRef) {
		this.actionRef = actionRef;
	}

	private void setActionGestionnaire(ActionGestionnaire actionGestionnaire) {
		this.actionGestionnaire = actionGestionnaire;
	}

	private ActionGestionnaire getActionGestionnaire() {
		return actionGestionnaire;
	}

	public static MainMenu getUniqInstance() {
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

}
