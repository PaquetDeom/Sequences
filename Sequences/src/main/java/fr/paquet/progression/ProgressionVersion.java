package fr.paquet.progression;

import java.util.List;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.progression.ProgressionVersionFactory;
import fr.paquet.dataBase.Factory.sequence.SequenceImplFactory;
import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.Auteur;
import fr.paquet.sequence.Sequence;
import fr.paquet.sequence.SequenceImpl;
import fr.paquet.sequence.SequenceVersion;

public class ProgressionVersion implements Progression {
	
	private long Id;

	private int numVersion = 0;

	private ProgressionImpl firstProgression;

	private ProgressionVersion previousParent;

	private Auteur auteur = null;
	
	public ProgressionVersion(String titre, Referentiel referentiel, Auteur auteur) throws Exception {
		this();
		this.firstProgression = new ProgressionImpl(titre, referentiel);
		this.numVersion = 1;
		setAuteur(auteur);
		setVisible(false);

		//new SequenceImplFactory().persist(firstSequence);

	}

	public ProgressionVersion(ProgressionVersion previousVersion) throws Exception {
		this();
		this.previousParent = previousVersion;
		this.firstProgression = previousVersion.firstProgression;
		setNumVersion(previousVersion.firstProgression);
		setVisible(false);
		setAuteur(Connect.getPConnexion().getUser().getAuteur());
		previousVersion.lock();
	}

	public ProgressionVersion() {
		super();
	}

	public Progression getParent() {
		if (previousParent != null)
			return previousParent;
		else
			return getFirstProgression();
	}

	public ProgressionImpl getFirstProgression() {
		return firstProgression;
	}

	private void setNumVersion(ProgressionImpl firstProgression) throws Exception {
		List<ProgressionVersion> pV = new ProgressionVersionFactory().findProgressionVersionByProgressionImpl(firstProgression);

		this.numVersion = pV.size() + 1;
	}

	@Override
	public void setModules(List<Module> modules) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTitre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Referentiel getReferentiel() {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setReferentiel(Referentiel referentiel) {
		// TODO Auto-generated method stub
		
	}

}
