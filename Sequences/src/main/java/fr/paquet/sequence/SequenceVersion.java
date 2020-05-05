package fr.paquet.sequence;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.sequence.SequenceImplFactory;
import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;

@Entity
@Table(name = "SEQUENCEVERSION")
public class SequenceVersion implements Sequence {

	@Id
	@GeneratedValue
	@Column(name = "SEVEID")
	private long Id;

	@Column
	private int numVersion = 0;

	@Transient
	private Sequence previousVersion;

	@JoinColumn
	private SequenceImpl firstSequence;

	@JoinColumn
	private SequenceVersion previous;

	@Column(name = "SEVECO", length = 20)
	private String contexte = null;

	@Column(name = "SEVELAST")
	private boolean dernier = true;

	@Column(name = "SEVEPR", length = 20)
	private String problematique = null;

	@Column(name = "SEVEPRE", length = 20)
	private String prerequis = null;

	@Column(name = "SEVEEL", length = 20)
	private String elementsARetenir = null;

	@Column(name = "SEVELI", length = 20)
	private String lien = null;

	@Column(name = "SEVEEV", length = 20)
	private String Eval = null;

	@Column(name = "SEVECL")
	private String classe = null;

	@ManyToOne
	private Auteur auteur = null;

	@Column(name = "SEVEVI")
	private boolean visible = false;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "SEQUENCEVERSION_SAVOIR_ASSOCIE", joinColumns = @JoinColumn(name = "SEVEID"), inverseJoinColumns = @JoinColumn(name = "SAASID"))
	private List<SavoirAssocie> savoirAssocies = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<SavoirAssocie> getSavoirAssocies() {
		if (savoirAssocies == null)
			savoirAssocies = (ArrayList<SavoirAssocie>) ((ArrayList<SavoirAssocie>) previousVersion.getSavoirAssocies())
					.clone();
		return savoirAssocies;
	}

	@Override
	public void setSavoirAssocies(List<SavoirAssocie> savoirAssocies) {
		this.savoirAssocies = savoirAssocies;

	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "SEQUENCEVERSION_COMPETENCE_INTERMEDIAIRE", joinColumns = @JoinColumn(name = "SEVEID"), inverseJoinColumns = @JoinColumn(name = "COINID"))
	private List<CompetenceIntermediaire> competenceIntermediaires = null;

	@SuppressWarnings("unchecked")
	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {

		if (competenceIntermediaires == null)
			competenceIntermediaires = (ArrayList<CompetenceIntermediaire>) ((ArrayList<CompetenceIntermediaire>) previousVersion
					.getCompetenceIntermediaires()).clone();
		return competenceIntermediaires;
	}

	@Override
	public void setCompetenceIntermediaires(List<CompetenceIntermediaire> competenceIntermediaires) {
		if (getCompetenceIntermediaires().isEmpty()) {
			firstSequence.setCapacite(competenceIntermediaires.get(0).getCompetence().getCapacite());
		}
		this.competenceIntermediaires = competenceIntermediaires;

	}

	@OneToMany(mappedBy = "sequence", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Activite_1> activites = null;

	@SuppressWarnings("unchecked")
	@Override
	public List<Activite_1> getActivites() {
		if (activites == null)
			activites = (ArrayList<Activite_1>) ((ArrayList<Activite_1>) previousVersion.getActivites()).clone();
		return activites;
	}

	public SequenceVersion(String titre, String classe, Referentiel referentiel, Auteur auteur) throws Exception {
		super();
		firstSequence = new SequenceImpl(titre, referentiel);
		previousVersion = firstSequence;
		numVersion = 1;
		setAuteur(auteur);
		setClasse(classe);
		setVisible(false);

		new SequenceImplFactory().persist(firstSequence);

	}

	public SequenceVersion(SequenceVersion previousVersion) throws Exception {
		super();
		this.previous = previousVersion;
		this.previousVersion = previousVersion;
		this.firstSequence = previousVersion.firstSequence;
		setNumVersion(previousVersion.firstSequence);
		setVisible(false);
		setAuteur(Connect.getPConnexion().getUser().getAuteur());
		previousVersion.lock();
	}

	public SequenceVersion getParent() {
		return previous;
	}

	public SequenceImpl getFirstSequence() {
		return firstSequence;
	}

	public SequenceVersion() {
		super();
	}

	private void setNumVersion(SequenceImpl firstSequence) throws Exception {
		List<SequenceVersion> sV = new SequenceVersionFactory().findSequenceVersionBySequenceImpl(firstSequence);

		this.numVersion = sV.size() + 1;
	}

	@Override
	public String getClasse() {
		return (classe != null) ? classe : previousVersion.getClasse();
	}

	@Override
	public Capacite getCapacite() {
		return firstSequence.getCapacite();
	}

	@Override
	public String getTitre() {
		return firstSequence.getTitre();
	}

	@Override
	public Referentiel getReferentiel() {

		return firstSequence.getReferentiel();
	}

	@Override
	public Auteur getAuteur() {
		return (auteur != null) ? auteur : previousVersion.getAuteur();
	}

	@Override
	public String getProblematique() {

		return (problematique != null) ? problematique : previousVersion.getProblematique();
	}

	@Override
	public void setProblematique(String problematique) {

		this.problematique = problematique;
	}

	@Override
	public String getPrerequis() {

		return (prerequis != null) ? prerequis : previousVersion.getPrerequis();
	}

	@Override
	public void setPrerequis(String prerequis) {

		this.prerequis = prerequis;
	}

	@Override
	public String getContexte() {
		return (this.contexte != null) ? this.contexte : previousVersion.getContexte();
	}

	@Override
	public void setContexte(String contexte) {
		this.contexte = contexte;
	}

	@Override
	public String getElementsARetenir() {
		String element = (elementsARetenir != null) ? elementsARetenir
				: (previousVersion != null) ? previousVersion.getElementsARetenir() : null;
		return element;
	}

	@Override
	public void setElementsARetenir(String elementsARetenir) {

		this.elementsARetenir = elementsARetenir;
	}

	@Override
	public String getLien() {

		return (lien != null) ? lien : previousVersion.getLien();
	}

	@Override
	public void setLien(String lien) {

		this.lien = lien;
	}

	@Override
	public String getEval() {

		return (Eval != null) ? Eval : previousVersion.getEval();
	}

	@Override
	public void setEval(String eval) {

		this.Eval = eval;
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Transient
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	@Override
	public void setVisible(boolean visible) {
		boolean oldVisible = this.visible;
		this.visible = visible;
		this.pcs.firePropertyChange("visible", oldVisible, visible);
	}

	@Override
	public boolean isModifiable(Auteur auteur) {
		return dernier && this.auteur.equals(auteur) && !isVisible();
	}

	@Override
	public int getnVersion() {
		return numVersion;
	}

	@Override
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	@Override
	public void lock() {
		dernier = false;
	}

	@Override
	public void unlock() {
		dernier = true;

	}

	@Override
	public void setClasse(String classe) {
		this.classe = classe;

	}

	@Override
	public void setCapacite(Capacite cap) {

	}

	@Override
	public void addActivite(Activite_1 activite) {
		getActivites().add(activite);

	}

	@Override
	public void addCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire) {

		if (getCompetenceIntermediaires().isEmpty())
			firstSequence.setCapacite(competenceIntermediaire.getCompetence().getCapacite());
		getCompetenceIntermediaires().add(competenceIntermediaire);

	}

	@Override
	public void removeActivite(Activite_1 activite) {
		getActivites().remove(activite);

	}

	@Override
	public void removeCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire) {
		getCompetenceIntermediaires().remove(competenceIntermediaire);

	}

	@Override
	public void addSavoirAssocies(SavoirAssocie savoirAssocie) throws Exception {
		if (!getSavoirAssocies().contains(savoirAssocie))
			getSavoirAssocies().add(savoirAssocie);
		else
			throw new Exception("Le savoir est déja dans la liste");

	}

	@Override
	public void removeSavoirAssocies(SavoirAssocie savoirAssocie) {
		getSavoirAssocies().remove(savoirAssocie);

	}

	@Override
	public void setActivites(List<Activite_1> activites) {
		this.activites = activites;

	}

	public String toString() {
		return "Version N°" + getnVersion() + " Classe : " + getClasse() + " Auteur : " + getAuteur().toString();
	}

}
