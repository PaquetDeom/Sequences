package fr.paquet.progression;

import java.util.List;

import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.Auteur;

public class ProgressionImpl implements Progression {

	private long id = 0;

	private String titre = null;

	private Referentiel referentiel = null;

	private int nVersion = 1;

	public ProgressionImpl(String titre, Referentiel referentiel) throws Exception {
		this();
		setTitre(titre);
		setReferentiel(referentiel);

	}

	public ProgressionImpl() {
		super();
	}

	@Override
	public void setModules(List<Module> modules) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitre() {

		return titre;
	}

	@Override
	public Referentiel getReferentiel() {

		return referentiel;
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

		return nVersion;
	}

	@Override
	public void setAuteur(Auteur auteur) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTitre(String titre) {
		this.titre = titre;

	}

	@Override
	public void setReferentiel(Referentiel referentiel) {
		this.referentiel = referentiel;

	}

}
