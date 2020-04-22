package fr.paquet.sequence;

import java.util.List;

import fr.paquet.activite.Activite_1;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;

public interface Sequence {

	public void setCapacite(Capacite cap);

	public List<Activite_1> getActivites();

	public String getClasse();

	public void setClasse(String classe);

	public Capacite getCapacite();

	public String getTitre();

	public Referentiel getReferentiel();

	public List<CompetenceIntermediaire> getCompetenceIntermediaires();

	public List<SavoirAssocie> getSavoirAssocies();

	public Auteur getAuteur();

	public String getProblematique();

	public void setProblematique(String problematique);

	public String getPrerequis();

	public void setPrerequis(String prerequis);

	public String getContexte();

	public void setContexte(String contexte);

	public String getElementsARetenir();

	public void setElementsARetenir(String elementsARetenir);

	public String getLien();

	public void setLien(String lien);

	public String getEval();

	public void setEval(String eval);

	public boolean isVisible();

	public void setVisible(boolean visible);

	public boolean isModifiable(Auteur auteur);

	public int getnVersion();

	public void setAuteur(Auteur auteur);

	public void lock();

	public void addActivite(Activite_1 activite);

	public void addCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire);

	public void addSavoirAssocies(SavoirAssocie savoirAssocie);

	public void removeActivite(Activite_1 activite);

	public void removeCompetenceIntermediaire(CompetenceIntermediaire competenceIntermediaire);

	public void removeSavoirAssocies(SavoirAssocie savoirAssocie);
}
