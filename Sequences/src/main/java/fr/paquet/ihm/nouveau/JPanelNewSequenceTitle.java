package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import fr.paquet.ihm.style.StyleFont;

import java.awt.Insets;

public class JPanelNewSequenceTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JTextField textField = null;

	public JPanelNewSequenceTitle(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);
		setTextField(new JTextField());

		// Ajout du layout
		setLayout(new GridBagLayout());

		// Attributs du panel

		// Getion de l'affichage
		add(new JLabel("Titre de la séquence :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(getTextField(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	public JTextField getTextField() {
		return textField;
	}

	private void setTextField(JTextField textField) {
		textField.setFont(StyleFont.TEXTEAREASEQUENCE.getFont());

		this.textField = textField;
	}

	public String getTitre() throws Exception {

		if (!getTextField().getText().equals(""))
			return getTextField().getText();
		else
			throw new Exception("La séquence doit avoir un titre");
	}

}
