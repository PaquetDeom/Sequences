package fr.paquet.ihm.commun;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

public abstract class CommunJLabelJTextAreaVertical extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Title = null;
	private JLabel titleLabel = null;
	protected JTextArea textArea = null;

	protected CommunJLabelJTextAreaVertical(String title) {
		super();

		// set des éléments
		setTitle(title);
		setTitleLabel(new JLabel(getTitle()));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Attribut du Jpanel
		setBackground(CommunStyle.PANELTITLE.getColor());

		// Ajout des Elements
		add(getTitleLabel(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getTextArea(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 5, 0), 0, 0));
	}

	private String getTitle() {
		return Title;
	}

	private void setTitle(String title) {
		Title = title;
	}

	private JLabel getTitleLabel() {
		return titleLabel;
	}

	private void setTitleLabel(JLabel titleLabel) {

		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.titleLabel = titleLabel;
	}

	private JTextArea getTextArea() {
		return textArea;
	}

	protected abstract void setTextArea(JTextArea textArea);

}
