package fr.paquet.ihm.commun;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

public abstract class CommunJLabelJTextAreaVertical extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Title = null;
	private JLabel titleLabel = null;
	protected JTextArea textArea = null;
	private JPanel panelTitre = null;
	private JPanel panelJTextArea = null;

	protected CommunJLabelJTextAreaVertical(String title) {
		super();

		// set des éléments
		setTitle(title);
		setTitleLabel(new JLabel(getTitle()));
		setTextArea(new JTextArea());
		setPanelTitre(new JPanel());
		setPanelJTextArea(new JPanel());

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des Elements
		add(getPanelTitre(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 1, 0));
		add(getPanelJTextArea(), new GridBagConstraints(0, 1, 1, 1, 1, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 1, 0));
		add(new JPanel(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 1, 0));
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
		titleLabel.setFont(StyleFont.TITLESEQ.getFont());
		this.titleLabel = titleLabel;
	}

	private JTextArea getTextArea() {
		return textArea;
	}

	protected abstract void setTextArea(JTextArea textArea);

	private JPanel getPanelTitre() {
		return panelTitre;
	}

	private void setPanelTitre(JPanel panelTitre) {

		// ajout du Layout
		panelTitre.setLayout(new FlowLayout());

		// attribut du panel
		panelTitre.setBackground(StyleColor.PANELTITLE.getColor());
		panelTitre.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());

		// ajut des component
		panelTitre.add(getTitleLabel());

		this.panelTitre = panelTitre;
	}

	private JPanel getPanelJTextArea() {
		return panelJTextArea;
	}

	private void setPanelJTextArea(JPanel panelJTextArea) {

		// ajout du Layout
		panelJTextArea.setLayout(new GridLayout(1, 0, 0, 0));

		// ajout des component
		panelJTextArea.add(getTextArea());

		// Attribut du panel
		panelJTextArea.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
		setPreferredSize(new Dimension(getPreferredSize().width, getPreferredSize().height * 8));
		this.panelJTextArea = panelJTextArea;
	}

}
