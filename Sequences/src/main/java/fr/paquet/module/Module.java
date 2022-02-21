package fr.paquet.module;

import java.util.List;

import fr.paquet.referentiel.Activite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.Auteur;

public interface Module {

	public Referentiel getReferentiel();
	
	public void setReferentiel(Referentiel referentiel);
	
	public void setActivite(Activite activite);
	
	public Activite getActivite();
	
	public List<CompetenceIntermediaire> getCompetenceIntermediaires();
	
	public List<Competence> getCompetences();
	
	public List<SavoirAssocie> getSavoirAssocies();
	
	public void setTitre(String titre);

	public String getTitre();

	public boolean isVisible();

	public void setVisible(boolean visible);

	public boolean isModifiable();

	public int getnVersion();

	public void setAuteur(Auteur auteur);
	
	public Auteur getAuteur();

	public void lock();

	public void unlock();

}
