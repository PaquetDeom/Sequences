package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class ActivitePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletActivite ongletActivite = null;
	private String titre = null;

	public ActivitePanel(OngletActivite ongletActivite) throws Exception {
		super();

		// set des composants
		setOngletActivite(ongletActivite);
		setTitre(getOngletActivite().getMainOnglet().getOngletsActivites().size() + 1);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		// add(new
		// SequencePanelVersion(getOngletActivite().getMainOnglet().getOngletSequence().getSequencePanel()),
		// new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
		// GridBagConstraints.BOTH,
		// new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelEntete(this), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelCorps(this), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelCompetencesSavoirs(this), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelActivite(this), new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelContexte(this), new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelConception(this), new GridBagConstraints(0, 6, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelStrategie(this), new GridBagConstraints(0, 7, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new JPanel(), new GridBagConstraints(0, 8, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attribut du Panel
	}

	private void setTitre(int size) {

		this.titre = "Activité N°" + size;
	}

	public String getTitre() {
		return titre;
	}

	public OngletActivite getOngletActivite() {
		return ongletActivite;
	}

	private void setOngletActivite(OngletActivite ongletActivite) {
		this.ongletActivite = ongletActivite;
	}

}
