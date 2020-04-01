package fr.paquet.ihm.commun;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import main.MainFrame;

public abstract class JModifyDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel maintenancePanel = null;
	private Object modifyObject = null;

	public JModifyDialog(Object o) throws Exception {
		super(MainFrame.getUniqInstance());
		setAlwaysOnTop(true);
		setModifyObject(o);
		JPanel mainPanel = new JPanel(new BorderLayout());
		setContentPane(mainPanel);

		maintenancePanel = new JPanel(new GridBagLayout());
		mainPanel.add(maintenancePanel, BorderLayout.CENTER);

		mainPanel.add(getButtonPanel(), BorderLayout.SOUTH);
		setVisible(true);
	}

	private Component getButtonPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridLayout());
		mainPanel.add(buttonPanel, BorderLayout.EAST);
		JButton btnSave = new JButton("Enregistrer");
		JButton btnCancel = new JButton("Annuler");
		btnSave.addActionListener(this);
		btnCancel.addActionListener(this);
		buttonPanel.add(btnSave);
		buttonPanel.add(btnCancel);
		return mainPanel;
	}

	public JPanel getMaintenancePanel() {
		return maintenancePanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enregistrer"))
			save();
		fireSelectedEvent(getModifyObject());
		this.dispose();

	}

	public abstract void save();

	private ArrayList<SelectListener> selectListeners = new ArrayList<SelectListener>();

	public void addSelectListener(SelectListener listener) {
		selectListeners.add(listener);
	}

	public void removeSelectListener(SelectListener listener) {
		selectListeners.remove(listener);
	}

	private void fireSelectedEvent(Object o) {
		for (SelectListener sl : selectListeners) {
			sl.objectSelected(new PropertyChangeEvent(this, o.getClass().toString(), null, o));
		}
	}

	public Object getModifyObject() {
		return modifyObject;
	}

	public void setModifyObject(Object modifyObject) {
		this.modifyObject = modifyObject;
	}
}
