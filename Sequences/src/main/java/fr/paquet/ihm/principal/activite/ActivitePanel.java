package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.principal.sequence.SequencePanelVersion;
import main.MainOnglet;

public class ActivitePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletActivite ongletActivite = null;
	private String titre = null;

	public ActivitePanel(OngletActivite ongletActivite) throws BadLocationException {
		super();

		// set des composants
		setOngletActivite(ongletActivite);
		setTitre(getOngletActivite().getActivite().getnActivite());

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		add(getsequencePanelVersion(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelEntete(this), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelCorps(this), new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getActivitePanelCompetencesSavoirs(), new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelActivite(this), new GridBagConstraints(0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelContexte(this), new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelConception(this), new GridBagConstraints(0, 6, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new ActivitePanelStrategie(this), new GridBagConstraints(0, 7, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attribut du Panel
	}

	private ActivitePanelCompetencesSavoirs activitePanelCompetencesSavoirs = null;

	public ActivitePanelCompetencesSavoirs getActivitePanelCompetencesSavoirs() {
		if (activitePanelCompetencesSavoirs == null)
			activitePanelCompetencesSavoirs = new ActivitePanelCompetencesSavoirs(this);
		return activitePanelCompetencesSavoirs;
	}

	private SequencePanelVersion sequencePanelVersion = null;

	public SequencePanelVersion getsequencePanelVersion() throws BadLocationException {
		if (sequencePanelVersion == null)
			sequencePanelVersion = new SequencePanelVersion(
					MainOnglet.getUniqInstance().getOngletSequence().getSequencePanel());
		return sequencePanelVersion;
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
