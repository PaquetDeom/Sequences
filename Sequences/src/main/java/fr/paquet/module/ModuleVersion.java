package fr.paquet.module;

import java.util.List;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.module.ModuleVersionFactory;
import fr.paquet.dataBase.Factory.progression.ProgressionVersionFactory;
import fr.paquet.progression.ProgressionImpl;
import fr.paquet.progression.ProgressionVersion;
import fr.paquet.referentiel.Activite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.Auteur;

public class ModuleVersion implements Module {

	private ModuleImpl firstModule = null;
	private ModuleVersion previousParent = null;
	private int numVersion = 0;
	private Auteur auteur = null;
	private boolean visible = false;

	public ModuleVersion(String titre, Referentiel referentiel, Auteur auteur) throws Exception {
		this();
		this.firstModule = new ModuleImpl(titre, referentiel);
		this.numVersion = 1;
		setAuteur(auteur);
		setVisible(false);

		// new ModuleImplFactory().persist(firstModule);

	}

	public ModuleVersion(ModuleVersion previousVersion) throws Exception {
		this();
		this.previousParent = previousVersion;
		this.firstModule = previousVersion.firstModule;
		setNumVersion(previousVersion.firstModule);
		setVisible(false);
		setAuteur(Connect.getPConnexion().getUser().getAuteur());
		previousVersion.lock();
	}

	public ModuleVersion() {
		super();
	}

	private void setNumVersion(ModuleImpl firstModule) throws Exception {
		List<ModuleVersion> mV = new ModuleVersionFactory().findModuleVersionByModuleImpl(firstModule);

		this.numVersion = mV.size() + 1;
	}

	public Module getParent() {
		if (previousParent != null)
			return previousParent;
		else
			return getFirstModule();
	}

	public ModuleImpl getFirstModule() {
		return firstModule;
	}

	@Override
	public Referentiel getReferentiel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReferentiel(Referentiel referentiel) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setActivite(Activite activite) {
		// TODO Auto-generated method stub

	}

	@Override
	public Activite getActivite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competence> getCompetences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SavoirAssocie> getSavoirAssocies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitre(String titre) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isModifiable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getnVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	@Override
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;

	}

	@Override
	public void lock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlock() {
		// TODO Auto-generated method stub

	}

	@Override
	public Auteur getAuteur() {

		if (this.auteur != null)
			return this.auteur;
		else if (getParent() != null)
			return getParent().getAuteur();
		else
			return null;
	}

}
