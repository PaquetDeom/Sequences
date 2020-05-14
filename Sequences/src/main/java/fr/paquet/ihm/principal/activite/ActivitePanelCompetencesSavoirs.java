package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;

public class ActivitePanelCompetencesSavoirs extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitePanel = null;

	public ActivitePanelCompetencesSavoirs(ActivitePanel activitePanel) throws BadLocationException {
		super();

		// set des composants
		setActivitePanel(activitePanel);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(getActiviteCompCompSavoir(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActiviteCompButton(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private ActiviteCompCompSavoir activiteCompCompSavoir = null;

	public ActiviteCompCompSavoir getActiviteCompCompSavoir() throws BadLocationException {
		if (activiteCompCompSavoir == null) {
			if (getActivite().getCompetencesIntermediaires().isEmpty())
				activiteCompCompSavoir = new ActiviteCompCompSavoir(this);
			else if (getActivite().getSavoirAssocies().isEmpty())
				activiteCompCompSavoir = new ActiviteCompCompSavoir(getActivite().getCompetencesIntermediaires(), null,
						this);
			else
				activiteCompCompSavoir = new ActiviteCompCompSavoir(getActivite().getCompetencesIntermediaires(),
						getActivite().getSavoirAssocies(), this);
		}
		return activiteCompCompSavoir;
	}

	private Activite_1 getActivite() {
		return getActivitePanel().getOngletActivite().getActivite();
	}

	private ActiviteCompButton activiteCompButton = null;

	public ActiviteCompButton getActiviteCompButton() {
		if (activiteCompButton == null)
			activiteCompButton = new ActiviteCompButton("+ Compétence", Title.COMPETENCES.getcolumn(), this);
		return activiteCompButton;
	}

	public ActivitePanel getActivitePanel() {
		return activitePanel;
	}

	private void setActivitePanel(ActivitePanel activitePanel) {
		this.activitePanel = activitePanel;
	}

	
}
