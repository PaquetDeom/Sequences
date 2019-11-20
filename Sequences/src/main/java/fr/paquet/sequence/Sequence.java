package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.activite.Activite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;

public class Sequence {

	private String titre = null;
	private Referentiel referentiel = null;
	private List<Competence> competences = null;
	private List<CompetenceIntermediaire> competenceIntermediaires = null;
	private List<Savoir> savoirs = null;
	private List<SavoirAssocie> savoirAssocies = null;
	private List<Activite> activites = null;

	public Sequence(String titre, Referentiel referentiel) throws Exception {
		this();
		setTitre(titre);
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

		this.referentiel = referentiel;
	}

	public Referentiel getReferentiel() {

		return referentiel;
	}

	public List<Activite> getActivites() {
		if (activites == null)
			activites = new ArrayList<Activite>();
		return activites;
	}

	public List<Competence> getCompetences() {
		if (competences == null)
			competences = new ArrayList<Competence>();
		return competences;
	}

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		if (competenceIntermediaires == null)
			competenceIntermediaires = new ArrayList<CompetenceIntermediaire>();
		return competenceIntermediaires;
	}

	public List<Savoir> getSavoirs() {
		if (savoirs == null)
			savoirs = new ArrayList<Savoir>();
		return savoirs;
	}

	public List<SavoirAssocie> getSavoirAssocies() {
		if (savoirAssocies == null)
			savoirAssocies = new ArrayList<SavoirAssocie>();
		return savoirAssocies;
	}

}
