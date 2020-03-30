package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

public class ActivitePanelActivite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	public ActivitePanelActivite(ActivitePanel activitePanel) {
		super();

		// set des composants.
		setActivitePanel(activitePanel);

		// ajout du Layout.
		setLayout(new GridBagLayout());

		// ajout des composants.
		add(getJLabel(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

		// attribut du panel.
		setBackground(StyleColor.PANELACTTITRE.getColor());
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private JLabel getJLabel() {

		JLabel label = new JLabel(getActivitePanel().getTitre());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(StyleFont.TITLEACT.getFont());

		return label;
	}

	public ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

}
