package fr.paquet.ihm.dataBase;

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

}
