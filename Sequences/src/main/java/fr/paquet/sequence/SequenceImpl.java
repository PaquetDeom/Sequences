package fr.paquet.sequence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Transient;

import fr.paquet.activite.Activite_1;

import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;

@Entity
@Table(name = "SEQUENCENUM")
public class SequenceImpl implements Sequence {

	@Id
	@GeneratedValue
	@Column(name = "SESEID")
	private long id = 0;

	@Column(name = "SESETI", length = 20)
	private String titre = null;

	@Transient
	private Referentiel referentiel = null;

	@Column(name = "SESEMO")
	private boolean modifiable = false;

	@Column(name = "SESEVE")
	private int nVersion = 1;

	public SequenceImpl(String titre, Referentiel referentiel) throws Exception {
		this();

		setTitre(titre);
		setReferentiel(referentiel);

	}

	public SequenceImpl() {
		super();
	}

	@Override
	public void setCapacite(Capacite cap) {

	}

	@Override
	public List<Activite_1> getActivites() {

		return null;
	}

	@Override
	public String getClasse() {

		return null;
	}

	@Override
	public void setClasse(String classe) {

	}

	@Override
	public Capacite getCapacite() {

		return null;
	}

	@Override
	public String getTitre() {

		return titre;
	}

	private void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public Referentiel getReferentiel() {

		return referentiel;
	}

	private void setReferentiel(Referentiel referentiel) {

		this.referentiel = referentiel;
	}

	@Override
	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {

		return new ArrayList<CompetenceIntermediaire>();
	}

	@Override
	public List<SavoirAssocie> getSavoirAssocies() {

		return new ArrayList<SavoirAssocie>();
	}

	@Override
	public Auteur getAuteur() {

		return null;
	}

	@Override
	public String getProblematique() {

		return null;
	}

	@Override
	public void setProblematique(String problematique) {

	}

	@Override
	public String getPrerequis() {

		return null;
	}

	@Override
	public void setPrerequis(String prerequis) {

	}

	@Override
	public String getContexte() {

		return null;
	}

	@Override
	public void setContexte(String contexte) {

	}

	@Override
	public String getElementsARetenir() {

		return null;
	}

	@Override
	public void setElementsARetenir(String elementsARetenir) {

	}

	@Override
	public String getLien() {

		return null;
	}

	@Override
	public void setLien(String lien) {

	}

	@Override
	public String getEval() {

		return null;
	}

	@Override
	public void setEval(String eval) {

	}

	@Override
	public boolean isVisible() {

		return false;
	}

	@Override
	public void setVisible(boolean visible) {

	}

	@Override
	public boolean isModifiable(Auteur auteur) {

		return true;
	}

	@Override
	public int getnVersion() {

		return nVersion;
	}

	@Override
	public void setAuteur(Auteur auteur) {

	}

	@Override
	public void lock() {

	}

	@Override
	public void addActivite(Activite_1 activite) {
		
		
	}

	@Override
	public void addCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire) {
		
		
	}

	@Override
	public void addSavoirAssocies(SavoirAssocie savoirAssocie) {
		
		
	}

	@Override
	public void removeActivite(Activite_1 activite) {
		
		
	}

	@Override
	public void removeCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire) {
		
		
	}

	@Override
	public void removeSavoirAssocies(SavoirAssocie savoirAssocie) {
		
		
	}

}
