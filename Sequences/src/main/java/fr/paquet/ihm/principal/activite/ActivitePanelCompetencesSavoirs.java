package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;

public class ActivitePanelCompetencesSavoirs extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	public ActivitePanelCompetencesSavoirs(ActivitePanel activitePanel)  {
		super();

		// set des composants
		setActivitePanel(activitePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(getActiviteCompTitre(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActiviteJPanelJlabel(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActiviteCompButton(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private ActiviteCompButton activiteCompButton = null;

	private ActiviteCompButton getActiviteCompButton() {
		if (activiteCompButton == null)
			activiteCompButton = new ActiviteCompButton("+ Compétence", Title.COMPETENCES.getcolumn(), this);
		return activiteCompButton;
	}

	private ActiviteJPanelJlabel activiteJPanelJlabel = null;

	public ActiviteJPanelJlabel getActiviteJPanelJlabel() {
		if (activiteJPanelJlabel == null)
			activiteJPanelJlabel = new ActiviteJPanelJlabel(this);
		return activiteJPanelJlabel;
	}

	private ActiviteCompTitre activiteCompTitre = null;

	private ActiviteCompTitre getActiviteCompTitre()  {
		if (activiteCompTitre == null)
			activiteCompTitre = new ActiviteCompTitre(Title.COMPETENCES, this);
		return activiteCompTitre;
	}

	public ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

	public void addCompetence() throws Exception {
		getActiviteJPanelJlabel().addCompetence();
		
	}

}
