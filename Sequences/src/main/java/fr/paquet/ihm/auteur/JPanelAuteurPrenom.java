package fr.paquet.ihm.auteur;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.paquet.ihm.commun.CommunJPanelHorizontalJLabelJTexField;

public class JPanelAuteurPrenom extends CommunJPanelHorizontalJLabelJTexField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelAuteurPrenom(JLabel jLabel, JTextField jTextField) {
		super(jLabel, jTextField);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void objectSelected(PropertyChangeEvent o) {
		// TODO Auto-generated method stub

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
