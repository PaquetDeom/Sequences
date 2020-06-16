package fr.paquet.activite;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

import fr.paquet.dataBase.Factory.Activite.Activite_1Factory;
import fr.paquet.dataBase.Factory.Activite.RessourceDocumentFactory;
import fr.paquet.dataBase.Factory.Activite.RessourceRessourcesFactory;
import fr.paquet.dataBase.Factory.Activite.RessourceTraceFactory;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.SequenceVersion;

@Entity
@Table(name = "ACTIVITE_1")
public class Activite_1 implements PropertyChangeListener {

	@Id
	@GeneratedValue
	@Column(name = "ACACID")
	private long id = 0;

	@Column(name = "ACACNA")
	private int nActivite = 0;

	@ManyToOne
	private SequenceVersion sequence = null;

	@Column(name = "ACACCO", length = 500)
	private String contexte = null;

	@Column(name = "ACACQU", length = 500)
	private String questionnement = null;

	public Activite_1() {
		super();
	}

	public Activite_1(SequenceVersion sequence) throws Exception {
		super();

		setSequence(sequence);

		this.nActivite = getSequenceVersion().getActivites().size() + 1;
		getSequenceVersion().addActivite(this);

		setStrategie(new Strategie(this));

		new Activite_1Factory().persist(this);

	}

	public int getnActivite() {
		return nActivite;
	}

	public SequenceVersion getSequenceVersion() {
		return sequence;
	}

	public void setSequence(SequenceVersion sequence) throws Exception {
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
		Savoir sav = savoirAssocie.getSavoir();

		for (CompetenceIntermediaire compint : getCompetencesIntermediaires()) {
			Competence comp = compint.getCompetence();
			if (comp.getSavoirs().contains(sav)) {
				getSavoirAssocies().add(savoirAssocie);
				break;
			}
		}

	}

	@Transient
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	public void setSavoirAssocies(List<SavoirAssocie> savoirAssocies) {
		List<SavoirAssocie> old = this.savoirAssocies;
		this.savoirAssocies = savoirAssocies;
		this.pcs.firePropertyChange("savoirAssocies", old, savoirAssocies);

	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	private List<CompetenceIntermediaire> competencesIntermédiaires = null;

	public List<CompetenceIntermediaire> getCompetencesIntermediaires() {
		if (competencesIntermédiaires == null)
			competencesIntermédiaires = new ArrayList<CompetenceIntermediaire>();
		return competencesIntermédiaires;
	}

	public void addCompetenceIntermediaire(CompetenceIntermediaire compInt) {
		getCompetencesIntermediaires().add(compInt);
	}

	public void setCompetencesIntermédiaires(List<CompetenceIntermediaire> competencesIntermédiaires) {

		this.competencesIntermédiaires = competencesIntermédiaires;

	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Strategie strategie = null;

	private void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}

	public Strategie getStrategie() {
		return strategie;
	}

	public String getContexte() {
		return contexte;
	}

	public void setContexte(String contexte) {
		contexte.trim();

		this.contexte = contexte;

	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RessourceDocument> documents = null;

	public List<RessourceDocument> getDocument() {
		if (documents == null)
			documents = new ArrayList<RessourceDocument>();
		return documents;
	}

	public void setDocument(List<RessourceDocument> documents) {

		this.documents = documents;

	}

	public void AddDocument(RessourceDocument ressource) throws Exception {

		if (!getDocument().isEmpty())
			for (RessourceDocument res1 : getDocument()) {
				if (res1.getText().equals(ressource.getText()))
					throw new Exception("Veuillez changer le titre de ce lien");

			}

		getDocument().add(ressource);
		new RessourceDocumentFactory().persist(ressource);

	}

	public void removeDocument(String text) {
		RessourceDocument dcc = null;

		for (RessourceDocument doc : getDocument()) {
			if (doc.getText().equals(text)) {
				doc = dcc;
				break;
			}
			getDocument().remove(dcc);
		}

	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RessourceRessouces> ressources = null;

	public List<RessourceRessouces> getRessources() {
		if (ressources == null)
			ressources = new ArrayList<RessourceRessouces>();
		return ressources;
	}

	public void setRessources(List<RessourceRessouces> ressources) {

		this.ressources = ressources;

	}

	public void AddRessource(RessourceRessouces ressource) throws Exception {

		if (!getRessources().isEmpty())
			for (RessourceRessouces res1 : getRessources()) {
				if (res1.getText().equals(ressource.getText()))
					throw new Exception("Veuillez changer le titre de ce lien");
			}

		getRessources().add(ressource);
		new RessourceRessourcesFactory().persist(ressource);
	}

	public void removeRessource(String text) {
		RessourceRessouces re = null;
		for (RessourceRessouces doc : getRessources()) {
			if (doc.getText().equals(text)) {
				doc = re;
				break;
			}

			getRessources().remove(re);
		}
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RessourceTrace> traces = null;

	public List<RessourceTrace> getTrace() {
		if (traces == null)
			traces = new ArrayList<RessourceTrace>();
		return traces;
	}

	public void setTrace(List<RessourceTrace> traces) {

		this.traces = traces;
	}

	public void AddTrace(RessourceTrace ressource) throws Exception {

		if (!getTrace().isEmpty())
			for (RessourceTrace res1 : getTrace()) {
				if (res1.getText().equals(ressource.getText()))
					throw new Exception("Veuillez changer le titre de ce lien");
			}

		getTrace().add(ressource);
		new RessourceTraceFactory().persist(ressource);
	}

	public void removeTrace(String text) {
		RessourceTrace tr = null;

		for (RessourceTrace trace : getTrace()) {
			if (trace.getText().equals(text)) {
				tr = trace;
				break;
			}
		}
		getTrace().remove(tr);
	}

	public String getQuestionnement() {
		return questionnement;
	}

	public void setQuestionnement(String questionnement) {
		questionnement.trim();
		this.questionnement = questionnement;
	}

	public double getDuree() {

		double duree = 0.0;

		if (getStrategie().getActiviteEleves().size() != 0) {
			for (ActiviteEleve aE : getStrategie().getActiviteEleves()) {
				duree = duree + aE.getDuree();
			}
		}

		return duree;
	}

	public String toString() {
		return "Activite " + getnActivite();
	}

	public void RemoveDocument(Ressource ressource) {

		Ressource res1 = null;

		for (Ressource res : getDocument()) {
			if (res.getText().equals(ressource.getText())) {
				res1 = res;
				break;
			}
		}

		getDocument().remove(res1);
		new RessourceDocumentFactory().removeObject(res1);

	}

	public void RemoveRessource(Ressource ressource) {

		Ressource res = null;

		for (Ressource res1 : getRessources()) {
			if (res1.getText().equals(ressource.getText())) {
				res = res1;
				break;
			}
		}

		getRessources().remove(res);
		new RessourceRessourcesFactory().removeObject(res);

	}

	public void RemoveTrace(Ressource ressource) {

		Ressource res1 = null;

		for (Ressource res : getTrace()) {
			if (res.getText().equals(ressource.getText())) {
				res1 = res;
				break;
			}

		}

		getTrace().remove(res1);
		new RessourceTraceFactory().removeObject(res1);

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {

		if (event.getNewValue() instanceof List<?> == true) {
			@SuppressWarnings("unchecked")
			List<SavoirAssocie> savs = (List<SavoirAssocie>) event.getNewValue();

			this.savoirAssocies = new ArrayList<SavoirAssocie>();

			for (SavoirAssocie savAss : savs) {
				addSavoirAssocie(savAss);
			}
		}

	}

}