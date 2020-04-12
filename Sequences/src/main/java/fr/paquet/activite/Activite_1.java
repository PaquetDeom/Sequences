package fr.paquet.activite;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.Sequence;

@Entity
@Table(name = "ACTIVITE")
public class Activite_1 {

	@Id
	@GeneratedValue
	@Column(name = "ACACID")
	private long id = 0;

	@Column(name = "ACACNA")
	private int nActivite = 0;

	@ManyToOne
	private Sequence sequence = null;

	@Column(name = "ACACCO", length = 400)
	private String contexte = null;

	@Column(name = "ACACDO", length = 400)
	private String document = null;

	@Column(name = "ACACRE", length = 400)
	private String ressources = null;

	@Column(name = "ACACTR", length = 400)
	private String trace = null;

	@Column(name = "ACACQU", length = 400)
	private String questionnement = null;

	public Activite_1() {
		super();
	}

	public Activite_1(Sequence sequence, int nActivite) throws Exception {
		super();

		setnActivite(nActivite);
		setSequence(sequence);
	}

	public int getnActivite() {
		return nActivite;
	}

	private void setnActivite(int nActivite) {
		this.nActivite = nActivite;
	}

	public Sequence getSequence() {
		return sequence;
	}

	public void setSequence(Sequence sequence) throws Exception {
		if (sequence == null)
			throw new Exception("Une activité doit provenir d'une séquence");
		this.sequence = sequence;
	}

	@OneToMany
	private List<CorpsDEtat> corpsDetatsConcernes = null;

	public List<CorpsDEtat> getCorpsDetatsConcernes() {
		if (corpsDetatsConcernes == null)
			corpsDetatsConcernes = new ArrayList<CorpsDEtat>();
		return corpsDetatsConcernes;
	}

	public void addCorpsDetats(CorpsDEtat corpsDetatsConcerne) {
		getCorpsDetatsConcernes().add(corpsDetatsConcerne);
	}

	public void setCorpsDetatsConcernes(List<CorpsDEtat> corpsDetatsConcernes) {
		this.corpsDetatsConcernes = corpsDetatsConcernes;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private List<SavoirAssocie> savoirAssocies = null;

	public List<SavoirAssocie> getSavoirAssocies() {
		if (savoirAssocies == null)
			savoirAssocies = new ArrayList<SavoirAssocie>();
		return savoirAssocies;
	}

	public void addSavoirAssocie(SavoirAssocie savoirAssocie) {
		getSavoirAssocies().add(savoirAssocie);
	}

	public void setSavoirAssocies(List<SavoirAssocie> savoirAssocies) {
		this.savoirAssocies = savoirAssocies;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private List<CompetenceIntermediaire> competencesIntermédiaires = null;

	public List<CompetenceIntermediaire> getCompetencesIntermédiaires() {
		if (competencesIntermédiaires == null)
			competencesIntermédiaires = new ArrayList<CompetenceIntermediaire>();
		return competencesIntermédiaires;
	}

	public void addCompetenceIntermediaire(CompetenceIntermediaire compInt) {
		getCompetencesIntermédiaires().add(compInt);
	}

	public void setCompetencesIntermédiaires(List<CompetenceIntermediaire> competencesIntermédiaires) {
		this.competencesIntermédiaires = competencesIntermédiaires;
	}

	@OneToOne
	private Strategie strategie = null;

	public Strategie getStrategie() {
		if (strategie == null)
			strategie = new Strategie();
		return strategie;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		contexte.trim();
		this.contexte = contexte;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		document.trim();
		this.document = document;
	}

	public String getRessources() {
		return ressources;
	}

	public void setRessources(String ressources) {
		ressources.trim();
		this.ressources = ressources;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		trace.trim();
		this.trace = trace;
	}

	public String getQuestionnement() {
		return questionnement;
	}

	public void setQuestionnement(String questionnement) {
		questionnement.trim();
		this.questionnement = questionnement;
	}

	public double getDuree() {

		double duree = 0;

		if (getStrategie().getActiviteEleves().size() != 0) {
			for (ActiviteEleve aE : getStrategie().getActiviteEleves()) {
				duree = duree + aE.getDuree();
			}
		}

		if (getStrategie().getActiviteProfs().size() != 0) {
			for (ActiviteProf aP : getStrategie().getActiviteProfs()) {
				duree = duree + aP.getDuree();
			}
		}
		return duree;
	}

}