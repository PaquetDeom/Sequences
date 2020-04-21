package fr.paquet.ihm.commun.gestionnaire;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;

public abstract class JPanelGestionnaireRight extends JPanel implements SelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogGestion jDialogGestion = null;
	private String titleButton = null;

	public JPanelGestionnaireRight(JDialogGestion jdialog, String titleButton) {
		super();

		// set des composants
		setTitleButton(titleButton);
		setjDialogGestion(jdialog);
		setPanelTitre(null);
		setPanelLeft(null);
		setPanelRight(null);

		// Ajout du layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		affiche();

		// attributs du Panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());
	}

	public void affiche() {
		removeAll();

		add(getPanelTitre(), new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		if (getPanelRight() != null) {
			add(getPanelLeft(), new GridBagConstraints(0, 1, 1, 1, 0.5, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			add(getPanelRight(), new GridBagConstraints(1, 1, 1, 1, 0.5, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		} else
			add(getPanelLeft(), new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getPanelButton(), new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		revalidate();
	}

	protected PanelLeftRight panelLeft = null;

	protected abstract void setPanelLeft(Object object);

	protected PanelLeftRight getPanelLeft() {

		return panelLeft;
	}

	protected PanelLeftRight panelRight = null;

	protected abstract void setPanelRight(Object object);

	protected PanelLeftRight getPanelRight() {
		return panelRight;
	}

	protected JPanel panelTitre = null;

	protected abstract void setPanelTitre(String Titre);

	private JPanel getPanelTitre() {

		return panelTitre;
	}

	private JButton button = null;

	public JButton getButtonAjouter() {
		if (button == null)
			button = new JButton(getTitleButton());
		return button;
	}

	private JPanel getPanelButton() {
		JPanel panel = new JPanel(new GridBagLayout());

		panel.add(new JLabel(" "), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(getButtonAjouter(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		return panel;
	}

	protected JDialogGestion getjDialogGestion() {
		return jDialogGestion;
	}

	private void setjDialogGestion(JDialogGestion jDialogGestion) {
		this.jDialogGestion = jDialogGestion;
	}

	private String getTitleButton() {
		return titleButton;
	}

	private void setTitleButton(String titleButton) {
		this.titleButton = titleButton;
	}
}
