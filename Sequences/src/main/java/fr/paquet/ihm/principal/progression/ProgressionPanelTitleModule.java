package fr.paquet.ihm.principal.progression;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public class ProgressionPanelTitleModule extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProgressionPanel progressionPanel = null;

	public ProgressionPanelTitleModule(ProgressionPanel progressionPanel) {
		super();

		setProgressionPanel(progressionPanel);

		// ajout d'un layout setLayout(new GridBagLayout());
		setLayout(new GridBagLayout());

		// Construction des JLabel getLabelNom(); getLabelVersion();
		getLabelAuteur();

		// ajout des composants.

		affiche();

		// attributs du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());
	}

	public void affiche() {

		removeAll();

		add(new JLabel("Nom du module : "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelNom(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Version N° : "), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelVersion(), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Referentiel : "), new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelReferentiel(), new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Nom de l'auteur : "), new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelAuteur(), new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Visibilité : "), new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelVisible(), new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(10, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		revalidate();
	}

	private JLabel getLabelVisible() {
		boolean a = MainFrame.getUniqInstance().getModuleVersion().isVisible();

		if (a == true)
			return new JLabel("Tout le monde |");
		else
			return new JLabel("Que moi |");
	}

	private JLabel getLabelReferentiel() {

		return new JLabel(MainFrame.getUniqInstance().getModuleVersion().getReferentiel().toString() + " | ");
	}

	private JLabel getLabelAuteur() {

		return new JLabel(MainFrame.getUniqInstance().getModuleVersion().getAuteur() + " | ");

	}

	private JLabel getLabelVersion() {

		return new JLabel("N°" + MainFrame.getUniqInstance().getModuleVersion().getnVersion() + " | ");

	}

	private JLabel getLabelNom() {

		if (MainFrame.getUniqInstance().getModuleVersion() == null)
			return new JLabel(" | ");
		else
			return new JLabel(MainFrame.getUniqInstance().getModuleVersion().getTitre() + " | ");

	}

	private void setProgressionPanel(ProgressionPanel progressionPanel) {
		this.progressionPanel = progressionPanel;

	}

	public ProgressionPanel getProgressionPanel() {
		return progressionPanel;
	}

}
