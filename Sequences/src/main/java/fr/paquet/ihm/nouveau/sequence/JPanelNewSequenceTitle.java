package fr.paquet.ihm.nouveau.sequence;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import fr.paquet.dataBase.Factory.sequence.SequenceImplFactory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.style.StyleFont;
import fr.paquet.sequence.SequenceImpl;

import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class JPanelNewSequenceTitle extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JTextField textField = null;
	private JPanelNewVersion jPanelNewVersion = null;

	public JPanelNewSequenceTitle(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);
		setTextField(new JTextField());

		// Ajout du layout
		setLayout(new GridBagLayout());

		// Attributs du panel

		// Gestion de l'affichage
		add(new JLabel("Titre de la séquence :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getTextField(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	public JPanelNewSequenceTitle(JPanelNewVersion jPanelNewVersion) {
		super();

		// setteur des éléments
		setjPanelNewVersion(jPanelNewVersion);
		setTextField(new JTextField(getjPanelNewVersion().getjDialogNewVersion().getSequenceVersionOld().getTitre()));
		getTextField().setEditable(false);

		// Ajout du layout
		setLayout(new GridBagLayout());

		// Attributs du panel

		// Gestion de l'affichage
		add(new JLabel("Titre de la séquence :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getTextField(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
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

		textField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent event) {
				if (getjPanelNewSequence() != null) {
					String title = getTextField().getText();

					SequenceImpl seq;
					try {
						seq = new SequenceImplFactory().findSequenceImplByTitle(title);

						if (seq != null) {
							new AlertWindow(AlertType.INFORMATION, "Le titre est déja utilisé dans la base");
							getTextField().setText(null);
						}

					} catch (Exception e) {
						e.printStackTrace();
						new AlertWindow(AlertType.ERREUR, e.getMessage());

					}
				}
			}

			@Override
			public void focusGained(FocusEvent event) {
				// DO NOTHING
			}
		});

		this.textField = textField;
	}

	public String getTitre() {

		return getTextField().getText();

	}

	public JPanelNewVersion getjPanelNewVersion() {
		return jPanelNewVersion;
	}

	public void setjPanelNewVersion(JPanelNewVersion jPanelNewVersion) {
		this.jPanelNewVersion = jPanelNewVersion;
	}

}
