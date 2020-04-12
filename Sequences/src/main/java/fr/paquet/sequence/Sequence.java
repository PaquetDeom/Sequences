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
public class Sequence {

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

	public Sequence(String titre, Referentiel referentiel, Auteur auteur) throws Exception {
		this();

		setTitre(titre);
		setReferentiel(referentiel);
		setAuteur(auteur);

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

	@OneToMany(mappedBy = "sequence", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Activite_1> activites = null;

	public List<Activite_1> getActivites() {
		if (activites == null)
			activites = new ArrayList<Activite_1>();
		return activites;
	}

	@Transient
	private List<CompetenceIntermediaire> competenceIntermediaires = null;

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		if (competenceIntermediaires == null)
			competenceIntermediaires = new ArrayList<CompetenceIntermediaire>();
		return competenceIntermediaires;
	}

	@Transient
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

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isModifiable() {
		return modifiable;
	}

	private void setModifiable(boolean modifiable) {

		// la sequence et modifiable uniquement par son auteur et si il n'y a pas de
		// version supérieur.
		if (getAuteur().equals(Connect.getPConnexion().getUser().getAuteur()))
			modifiable = true;

		this.modifiable = modifiable;
	}

}
