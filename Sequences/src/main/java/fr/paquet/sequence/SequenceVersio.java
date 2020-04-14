package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;

public class SequenceVersio {

	private String titreVers = null;
	private Referentiel referentielVers = null;
	private Auteur auteurVers = null;
	private String problematiqueVers = null;
	private String prerequisVers = null;
	private String contexteVers = null;
	private String elementsARetenirVers = null;
	private String lienVers = null;
	private String EvalVers = null;
	private boolean visibleVers = false;
	private boolean modifiableVers = false;
	private int nVersionVers = 0;

	public SequenceVersio() {
		super();
	}

	protected String getTitreVers() {
		return titreVers;
	}

	private void setTitreVers(String titreVers) {
		this.titreVers = titreVers;
	}

	private void setReferentielVers(Referentiel referentielVers) {

		this.referentielVers = referentielVers;
	}

	protected Referentiel getReferentielVers() {

		return referentielVers;
	}

	private List<Activite_1> activitesVers = null;

	protected List<Activite_1> getActivitesVers() {
		if (activitesVers == null)
			activitesVers = new ArrayList<Activite_1>();
		return activitesVers;
	}

	private List<CompetenceIntermediaire> competenceIntermediairesVers = null;

	protected List<CompetenceIntermediaire> getCompetenceIntermediairesVers() {
		if (competenceIntermediairesVers == null)
			competenceIntermediairesVers = new ArrayList<CompetenceIntermediaire>();
		return competenceIntermediairesVers;
	}

	private List<SavoirAssocie> savoirAssociesVers = null;

	protected List<SavoirAssocie> getSavoirAssociesVers() {
		if (savoirAssociesVers == null)
			savoirAssociesVers = new ArrayList<SavoirAssocie>();
		return savoirAssociesVers;
	}

	protected Auteur getAuteurVers() {
		return auteurVers;
	}

	private void setAuteurVers(Auteur auteurVers) {
		this.auteurVers = auteurVers;
	}

	protected String getProblematiqueVers() {
		return problematiqueVers;
	}

	public void setProblematiqueVers(String problematiqueVers) {
		this.problematiqueVers = problematiqueVers;
	}

	protected String getPrerequisVers() {
		return prerequisVers;
	}

	public void setPrerequisVers(String prerequisVers) {
		this.prerequisVers = prerequisVers;
	}

	protected String getContexteVers() {
		return contexteVers;
	}

	public void setContexteVers(String contexteVers) {
		this.contexteVers = contexteVers;
	}

	protected String getElementsARetenirVers() {
		return elementsARetenirVers;
	}

	public void setElementsARetenirVers(String elementsARetenirVers) {
		this.elementsARetenirVers = elementsARetenirVers;
	}

	protected String getLienVers() {
		return lienVers;
	}

	public void setLienVers(String lienVers) {
		this.lienVers = lienVers;
	}

	protected String getEvalVers() {
		return EvalVers;
	}

	public void setEvalVers(String evalVers) {
		EvalVers = evalVers;
	}

	protected boolean isVisibleVers() {
		return visibleVers;
	}

	public void setVisibleVers(boolean visibleVers) {
		this.visibleVers = visibleVers;
	}

	protected boolean isModifiableVers() {
		return modifiableVers;
	}

	private void setModifiableVers(boolean modifiableVers) {

		// la sequence et modifiable uniquement par son auteur et si il n'y a pas de
		// version supérieur.
		if (getAuteurVers().equals(Connect.getPConnexion().getUser().getAuteur()))
			modifiableVers = true;

		this.modifiableVers = modifiableVers;
	}

	protected int getnVersionVers() {
		return nVersionVers;
	}

	public void setnVersionVers(int nVersionVers) {
		this.nVersionVers = nVersionVers;
	}

}
