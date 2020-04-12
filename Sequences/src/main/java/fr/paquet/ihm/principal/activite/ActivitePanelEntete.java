package fr.paquet.ihm.principal.activite;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

import javax.swing.SwingConstants;

public class ActivitePanelEntete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	public ActivitePanelEntete(ActivitePanel activitePanel) {
		super();

		// set des composants
		setActivitePanel(activitePanel);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des Composants
		add(getActivitePanelTitre(), new GridBagConstraints(0, 0, 1, 1, 0.5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
		add(getActivitePanelEnteteImage(), new GridBagConstraints(1, 0, 1, 1, 0.5, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

		// attribut du Jpanel
		setPreferredSize(new Dimension(0, getPreferredSize().height * 4));

	}

	private JPanel getActivitePanelTitre() {
		JPanel jP = new JPanel();

		// attribut du JPanel
		jP.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
		jP.setBackground(StyleColor.PANELTITLESUPPORT.getColor());

		// ajout du Layout
		jP.setLayout(new BorderLayout());

		// ajout du JLabel Titre
		jP.add(getLabelTitle(), BorderLayout.CENTER);
		jP.add(new JPanel(), BorderLayout.NORTH);
		jP.add(new JPanel(), BorderLayout.SOUTH);
		jP.add(new JPanel(), BorderLayout.EAST);
		jP.add(new JPanel(), BorderLayout.WEST);

		return jP;
	}

	private JLabel getLabelTitle() {

		JLabel label = new JLabel("SUPPORT PEDAGOGIQUE");
		label.setFont(StyleFont.TITLEACT.getFont());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);

		return label;
	}

	private ActivitePanelEnteteImage activitePanelEnteteImage = null;

	private ActivitePanelEnteteImage getActivitePanelEnteteImage() {
		if (activitePanelEnteteImage == null)
			activitePanelEnteteImage = new ActivitePanelEnteteImage(null, this);
		return activitePanelEnteteImage;
	}

	private ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

}
