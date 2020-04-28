package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public class SequencePanelVersion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;

	public SequencePanelVersion(SequencePanel sequencePanel) {
		super();

		setSequencePanel(sequencePanel);

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

		add(new JLabel("Nom de la séquence : "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
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
		add(new JLabel("Classe Concernée : "), new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelClasse(), new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JLabel("Visibilité : "), new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getLabelVisible(), new GridBagConstraints(11, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(12, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		revalidate();
	}

	private JLabel getLabelVisible() {
		boolean a = MainFrame.getUniqInstance().getSequenceVersion().isVisible();

		if (a == true)
			return new JLabel("Tout le monde |");
		else
			return new JLabel("Que moi |");
	}

	private JLabel getLabelReferentiel() {

		return new JLabel(
				MainFrame.getUniqInstance().getSequenceVersion().getReferentiel().toString()
						+ " | ");
	}

	private JLabel getLabelClasse() {

		return new JLabel(MainFrame.getUniqInstance().getSequenceVersion().getClasse() + " | ");
	}

	private JLabel getLabelAuteur() {

		return new JLabel(MainFrame.getUniqInstance().getSequenceVersion().getAuteur() + " | ");

	}

	private JLabel getLabelVersion() {

		return new JLabel(
				"N°" + MainFrame.getUniqInstance().getSequenceVersion().getnVersion() + " | ");

	}

	private JLabel getLabelNom() {

		if (MainFrame.getUniqInstance().getSequenceVersion() == null)
			return new JLabel(" | ");
		else
			return new JLabel(MainFrame.getUniqInstance().getSequenceVersion().getTitre() + " | ");

	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

}
