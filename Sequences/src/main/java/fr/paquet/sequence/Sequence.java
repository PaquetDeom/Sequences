package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.activite.Activite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.version.VersionSequence;

public class Sequence {

	private String titre = null;
	private Referentiel referentiel = null;
	private Auteur auteur = null;
	private String problematique = null;
	private String prerequis = null;
	private String contexte = null;
	private String elementsARetenir = null;
	private String lien = null;
	private String Eval = null;
	private VersionSequence versionSequence = null;

	public Sequence(String titre, Referentiel referentiel, Auteur auteur, VersionSequence versionSequence)
			throws Exception {
		this();

		setTitre(titre);
		setReferentiel(referentiel);
		setAuteur(auteur);
		setVersionSequence(versionSequence);

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

	private List<Activite> activites = null;

	public List<Activite> getActivites() {
		if (activites == null)
			activites = new ArrayList<Activite>();
		return activites;
	}

	private List<CompetenceIntermediaire> competenceIntermediaires = null;

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		if (competenceIntermediaires == null)
			competenceIntermediaires = new ArrayList<CompetenceIntermediaire>();
		return competenceIntermediaires;
	}

	private List<SavoirAssocie> savoirAssocies = null;

	public List<SavoirAssocie> getSavoirAssocies() {
		if (savoirAssocies == null)
			savoirAssocies = new ArrayList<SavoirAssocie>();
		return savoirAssocies;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	private void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public String getProblematique() {
		return problematique;
	}

	public void setProblematique(String problematique) {
		this.problematique = problematique;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getElementsARetenir() {
		return elementsARetenir;
	}

	public void setElementsARetenir(String elementsARetenir) {
		this.elementsARetenir = elementsARetenir;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getEval() {
		return Eval;
	}

	public void setEval(String eval) {
		Eval = eval;
	}

	public VersionSequence getVersionSequence() {
		return versionSequence;
	}

	public void setVersionSequence(VersionSequence versionSequence) {
		if (versionSequence == null)
			versionSequence = new VersionSequence(null, this, null, getAuteur());
		this.versionSequence = versionSequence;
	}

}
