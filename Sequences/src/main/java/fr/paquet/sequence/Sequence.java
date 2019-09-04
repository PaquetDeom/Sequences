package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.activite.Activite;
import fr.paquet.referentiel.Referentiel;

public class Sequence {

	private String titre = null;
	private Referentiel referentiel = null;
	private List<Activite> activites = null;

	public Sequence(String titre) throws Exception {
		this();
		setTitre(titre);
	}

	public Sequence(String titre, Referentiel referentiel) throws Exception {
		this(titre);
		setReferentiel(referentiel);
	}

	public Sequence() {
		super();
	}

	public String getTitre() {
		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	private void setReferentiel(Referentiel referentiel) {
		// TODO
		this.referentiel = referentiel;
	}

	public Referentiel getReferentiel() {
		// TODO Auto-generated method stub
		return referentiel;
	}

	public List<Activite> getActivites() {
		if (activites == null)
			activites = new ArrayList<Activite>();
		return activites;
	}

}
