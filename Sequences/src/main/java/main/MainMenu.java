package main;

import java.util.Hashtable;

import javax.swing.*;

import fr.paquet.ihm.action.*;
import fr.paquet.sequence.SequenceVersion;

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
	private ActionActivite actionActivites = null;
	private ActionCompetences actionCompetences = null;
	private ActionNewVersion actionNewVersion = null;
	private ActionVisible actionVisible = null;

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
		setActionNewVersion(new ActionNewVersion());
		addAction(getActionNewVersion());
		setActionVisible(new ActionVisible());
		addAction(getActionVisible());
		setActionCompetences(new ActionCompetences());
		addAction(getActionCompetences());
		setActionActivites(new ActionActivite());
		addAction(getActionActivites());
		addAction(new ActionQuitter());

	}

	public void addSequence(SequenceVersion seq) throws Exception {
		getActionRef().setSequenceVersion(seq);
		getActionSave().setSequence(seq);
		getActionNewVersion().setSequence(seq);
		getActionCompetences().setSequence(seq);
		getActionActivites().setSequence(seq);
		getActionVisible().setSequence(seq);

	}

	private ActionActivite getActionActivites() {

		return actionActivites;
	}

	private ActionCompetences getActionCompetences() {

		return actionCompetences;
	}

	private ActionNewVersion getActionNewVersion() {
		return actionNewVersion;
	}

	private void setActionActivites(ActionActivite actionActivite) {
		this.actionActivites = actionActivite;

	}

	private void setActionCompetences(ActionCompetences actionCompetences) {
		this.actionCompetences = actionCompetences;

	}

	private void setActionNewVersion(ActionNewVersion actionNewVersion) {
		this.actionNewVersion = actionNewVersion;

	}

	private ActionRef getActionRef() {

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

	private ActionSave getActionSave() {
		return actionSave;
	}

	private void setActionSave(ActionSave actionSave) {
		this.actionSave = actionSave;
	}

	private ActionVisible getActionVisible() {
		return actionVisible;
	}

	private void setActionVisible(ActionVisible actionVisible) {
		this.actionVisible = actionVisible;
	}

}
