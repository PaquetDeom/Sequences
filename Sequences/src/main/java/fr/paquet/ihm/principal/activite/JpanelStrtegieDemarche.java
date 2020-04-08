package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EnumSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.paquet.activite.DemarchePedagogique;
import fr.paquet.ihm.style.StyleBorder;

public class JpanelStrtegieDemarche extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelStrategie activitePanelStrategie = null;
	private JComboBox<String> demarcheBox = null;

	public JpanelStrtegieDemarche(ActivitePanelStrategie activitePanelStrategie) {
		super();

		// set des composants
		setActivitePanelStrategie(activitePanelStrategie);
		setDemarche(new JComboBox<String>());

		// ajout de layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(new JLabel("Démarche pédagogique : "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getDemarche(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attributs du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

		// listener

	}

	private void setDemarche(JComboBox<String> demarcheBox) {

		demarcheBox.addItem(" ");

		for (DemarchePedagogique dem : EnumSet.allOf(DemarchePedagogique.class)) {
			demarcheBox.addItem(dem.getTitre());
		}

		this.demarcheBox = demarcheBox;
	}

	public JComboBox<String> getDemarche() {
		return demarcheBox;
	}

	public ActivitePanelStrategie getActivitePanelStrategie() {
		return activitePanelStrategie;
	}

	private void setActivitePanelStrategie(ActivitePanelStrategie activitePanelStrategie) {
		this.activitePanelStrategie = activitePanelStrategie;
	}

}
