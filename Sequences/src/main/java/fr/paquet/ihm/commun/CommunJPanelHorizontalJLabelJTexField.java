package fr.paquet.ihm.commun;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public abstract class CommunJPanelHorizontalJLabelJTexField extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel jlabel = null;
	protected JTextField jTextField = null;

	public CommunJPanelHorizontalJLabelJTexField(JLabel jLabel, JTextField jTextField) {
		super();

		// setteur des éléments
		setJLabel(jLabel);
		setJTextField(jTextField);

		// Ajout du layout
		setLayout(new GridBagLayout());

		// Attributs du panel

		// Getion de l'affichage
		add(getJlabel(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(getjTextField(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
	}
	
	protected abstract void setJLabel(JLabel jLabel);
	protected abstract void setJTextField(JTextField jTextField);

	public JLabel getJlabel() {
		return jlabel;
	}

	public JTextField getjTextField() {
		return jTextField;
	}
	
	
}
