package fr.paquet.version;

import fr.paquet.sequence.Auteur;
import fr.paquet.sequence.Sequence;

public class VersionSequence {

	private Auteur auteur = null;
	private Sequence SeqActuelle = null;
	private Sequence SeqVerSup = null;
	private Sequence SeqVerOld = null;
	private int NVersion = 0;

	public VersionSequence(Sequence seqVerOld, Sequence seqActuelle, Sequence seqVerSup, Auteur auteur) {
		super();

		// set des elements
		setSeqActuelle(seqActuelle);
		setSeqVerSup(seqVerSup);
		setSeqVerOld(seqVerOld);
		setAuteur(auteur);
	}

	public int getNVersion() {
		return NVersion;
	}

	public void setNVersion(int nVersion) {
		NVersion = nVersion;
	}

	public boolean isModifiable() {
		boolean modif = true;

		if (getSeqVerSup() != null)
			modif = false;
		if (getSeqActuelle().getAuteur() != getAuteur())
			modif = false;
		return modif;
	}

	public Sequence getSeqActuelle() {
		return SeqActuelle;
	}

	private void setSeqActuelle(Sequence seqActuelle) {
		SeqActuelle = seqActuelle;
	}

	public Sequence getSeqVerSup() {
		return SeqVerSup;
	}

	private void setSeqVerSup(Sequence seqVerSup) {
		SeqVerSup = seqVerSup;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	private void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Sequence getSequence() throws Exception {
		//TODO
		Sequence seq = new Sequence();
		return seq;
	}

	public Sequence getSeqVerOld() {
		return SeqVerOld;
	}

	public void setSeqVerOld(Sequence seqVerOld) {
		SeqVerOld = seqVerOld;
	}

}
