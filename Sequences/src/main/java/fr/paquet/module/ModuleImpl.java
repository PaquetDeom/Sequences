package fr.paquet.module;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;

import fr.paquet.referentiel.Activite;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.Auteur;

public class ModuleImpl implements Module {

	private long id = 0;

	private String titre = null;

	private Referentiel referentiel = null;

	private Activite activite = null;

	private Auteur auteur = null;

	private boolean modifiable = false;

	private int nVersion = 1;

	public ModuleImpl(String titre, Referentiel referentiel) throws Exception {
		this();

		setTitre(titre);
		setReferentiel(referentiel);

	}

	public ModuleImpl() {
		super();
	}

	@Override
	public Referentiel getReferentiel() {

		return referentiel;
	}

	@Override
	public void setActivite(Activite activite) {

	}

	@Override
	public Activite getActivite() {

		return activite;
	}

	@Override
	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {

		return null;
	}

	@Override
	public List<Competence> getCompetences() {

		return null;
	}

	@Override
	public List<SavoirAssocie> getSavoirAssocies() {

		return null;
	}

	@Override
	public String getTitre() {

		return titre;
	}

	@Override
	public boolean isVisible() {

		return false;
	}

	@Override
	public void setVisible(boolean visible) {

	}

	@Override
	public boolean isModifiable() {

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
	public void unlock() {

	}

	@Override
	public void setReferentiel(Referentiel referentiel) {

	}

	@Override
	public void setTitre(String titre) {

	}

	@Override
	public Auteur getAuteur() {

		return auteur;
	}

}
