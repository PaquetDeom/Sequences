package fr.paquet.ihm.dataBase;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.paquet.ihm.commun.CommunJPanelHorizontalJLabelJTexField;

public class JPanelNewUser extends CommunJPanelHorizontalJLabelJTexField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelNewUser(JLabel jLabel, JTextField jTextField) {
		super(jLabel, jTextField);
	}

	@Override
	protected void setJLabel(JLabel jLabel) {
		this.jlabel = jLabel;

	}

	@Override
	protected void setJTextField(JTextField jTextField) {
		this.jTextField = jTextField;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectSelected(PropertyChangeEvent o) {
		// TODO Auto-generated method stub
		
	}

}
