package fr.paquet.ihm.commun;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

public abstract class CommunJDialogTextField extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton buttonOk = null;
	protected JButton buttonAnnul = null;
	protected JTextField titleField = null;
	protected JLabel titleLabel = null;

	protected CommunJDialogTextField(String title, String titleLabel) {
		super();
		setTitle(title);
		setTitleLabel(new JLabel(titleLabel));
		setButtonOk(new JButton("Ok"));
		setButtonAnnul(new JButton("Annul"));
		setTitleField(new JTextField(50));

		// construction de la fenêtre
		setTitle(getTitle());
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setVisible(true);
		setModal(true);

		// creation du layout
		GridBagLayout gridBagLayout = new GridBagLayout();

		// ajout du layout au panel
		getContentPane().setLayout(gridBagLayout);

		//new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady)
		// ajout de du label et du textField;
		getContentPane().add(getTitleLabel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 2.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(2, 2, 2, 2), 0, 0));
		getContentPane().add(getTitleField(), new GridBagConstraints(1, 0, 1, 1, 2.0, 3.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

		// création d'un panelButton
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new BorderLayout());
		JPanel pB2 = new JPanel();
		pB2.setLayout(new GridLayout());

		pB2.add(getButtonAnnul());
		pB2.add(getButtonOk());
		panelButton.add(pB2, BorderLayout.EAST);

		getContentPane().add(panelButton, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	}

	public JButton getButtonOk() {
		return buttonOk;
	}

	public JButton getButtonAnnul() {
		return buttonAnnul;
	}

	public JTextField getTitleField() {
		return titleField;
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	protected abstract void setButtonOk(JButton buttonOk);

	protected abstract void setButtonAnnul(JButton buttonAnnul);

	protected abstract void setTitleField(JTextField titleField);

	protected abstract void setTitleLabel(JLabel TitleLabel);

}
