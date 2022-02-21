package fr.paquet.progression;

import java.util.List;

import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.Auteur;

public interface Progression {
	
	public void setTitre(String titre);
	
	public void setReferentiel(Referentiel referentiel);

	public void setModules(List<Module> modules);

	public String getTitre();

	public Referentiel getReferentiel();

	public boolean isVisible();

	public void setVisible(boolean visible);

	public boolean isModifiable();

	public int getnVersion();

	public void setAuteur(Auteur auteur);

	public Auteur getAuteur();

	public void lock();

	public void unlock();

}
