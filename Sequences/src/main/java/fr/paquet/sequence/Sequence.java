package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;

@Entity
@Table(name = "SEQUENCENUM")
public class Sequence extends SequenceVersio {

	@Id
	@GeneratedValue
	@Column(name = "SESEID")
	private long id = 0;

	@Column(name = "SESETI", length = 20)
	private String titre = null;

	@Transient
	private Referentiel referentiel = null;

	@ManyToOne
	private Auteur auteur = null;

	@Column(name = "SESEPR", length = 20)
	private String problematique = null;

	@Column(name = "SESEPRE", length = 20)
	private String prerequis = null;

	@Column(name = "SESECO", length = 20)
	private String contexte = null;

	@Column(name = "SESEEL", length = 20)
	private String elementsARetenir = null;

	@Column(name = "SESELI", length = 20)
	private String lien = null;

	@Column(name = "SESEEV", length = 20)
	private String Eval = null;

	@Column(name = "SESEVI")
	private boolean visible = false;

	@Column(name = "SESEMO")
	private boolean modifiable = false;

	@Column(name = "SESEVE")
	private int nVersion = 0;

	public Sequence(String titre, Referentiel referentiel, Auteur auteur, int nVersion) throws Exception {
		this();

		setTitre(titre);
		setReferentiel(referentiel);
		setAuteur(auteur);
		setnVersion(nVersion);

	}

	public Sequence() {
		super();
	}

	/**
	 * 
	 * @return la première capacite de la competence intermediaire, pout trier les
	 *         sequences</br>
	 */
	public Capacite getCapacite() {
		if (getCompetenceIntermediaires().isEmpty() || getCompetenceIntermediaires() == null)
			return null;
		else
			return getCompetenceIntermediaires().get(0).getCompetence().getCapacite();
	}

	public String getTitre() {
		if (getTitreVers() == null)
			return titre;
		else
			return getTitreVers();
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	private void setReferentiel(Referentiel referentiel) {

		this.referentiel = referentiel;
	}

	public Referentiel getReferentiel() {

		if (getReferentielVers() == null)
			return referentiel;
		else
			return getReferentielVers();
	}

	@OneToMany(mappedBy = "sequence", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Activite_1> activites = null;

	public List<Activite_1> getActivites() {

		if (getActivitesVers() == null) {
			if (activites == null)
				activites = new ArrayList<Activite_1>();
			return activites;
		} else
			return getActivitesVers();
	}

	@Transient
	private List<CompetenceIntermediaire> competenceIntermediaires = null;

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {

		if (getCompetenceIntermediairesVers() == null) {
			if (competenceIntermediaires == null)
				competenceIntermediaires = new ArrayList<CompetenceIntermediaire>();
			return competenceIntermediaires;
		} else
			return getCompetenceIntermediairesVers();
	}

	@Transient
	private List<SavoirAssocie> savoirAssocies = null;

	public List<SavoirAssocie> getSavoirAssocies() {

		if (getSavoirAssociesVers() == null) {
			if (savoirAssocies == null)
				savoirAssocies = new ArrayList<SavoirAssocie>();
			return savoirAssocies;
		} else
			return getSavoirAssociesVers();
	}

	public Auteur getAuteur() {
		if (getAuteurVers() == null)
			return auteur;
		else
			return getAuteurVers();
	}

	private void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public String getProblematique() {
		if (getProblematiqueVers() == null)
			return problematique;
		else
			return getProblematiqueVers();
	}

	public void setProblematique(String problematique) {
		this.problematique = problematique;
	}

	public String getPrerequis() {
		if (getPrerequisVers() == null)
			return prerequis;
		else
			return getPrerequisVers();
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContexte() {
		if (getContexteVers() == null)
			return contexte;
		else
			return getContexteVers();
	}

	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	public String getElementsARetenir() {
		if (getElementsARetenirVers() == null)
			return elementsARetenir;
		else
			return getElementsARetenirVers();
	}

	public void setElementsARetenir(String elementsARetenir) {
		this.elementsARetenir = elementsARetenir;
	}

	public String getLien() {
		if (getLienVers() == null)
			return lien;
		else
			return getLienVers();
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getEval() {
		if (getEvalVers() == null)
			return Eval;
		else
			return getEvalVers();
	}

	public void setEval(String eval) {
		Eval = eval;
	}

	public boolean isVisible() {
		// TODO
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isModifiable() {
		// TODO
		return modifiable;
	}

	private void setModifiable(boolean modifiable) {

		// la sequence et modifiable uniquement par son auteur et si il n'y a pas de
		// version supérieur.
		if (getAuteur().equals(Connect.getPConnexion().getUser().getAuteur()) && getnVersionVers() == 0)
			modifiable = true;

		this.modifiable = modifiable;
	}

	public int getnVersion() {
		if (getnVersionVers() == 0)
			return nVersion;
		else
			return getnVersionVers();
	}

	private void setnVersion(int nVersion) {
		this.nVersion = nVersion;
	}

}
