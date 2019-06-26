package main;

import java.util.*;

import javax.swing.*;

import fr.paquet.ihm.principal.activite.OngletActivite;
import fr.paquet.ihm.principal.sequence.OngletSequence;
import fr.paquet.sequence.Sequence;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private OngletSequence ongletSequence = null;
	private Sequence sequence = null;
	private List<OngletActivite> ongletsActivites = null;

	/**
	 * Constructeur de la class private car ne doit etre instanciee qu une fois<br/>
	 * 
	 * 
	 */
	public MainOnglet(Sequence sequence) {
		super(SwingConstants.TOP);

		// setteur des component
		setSequence(sequence);
		setOngletSequence(new OngletSequence(this));

		if (getSequence().getSeances() != null && !getSequence().getSeances().isEmpty())
			initOngletsActivites();

	}

	public OngletSequence getOngletSequence() {
		return ongletSequence;
	}

	public void setOngletSequence(OngletSequence ongletSequence) {
		this.ongletSequence = ongletSequence;
	}

	public List<OngletActivite> getOngletsActivites() {

		if (ongletsActivites == null)
			ongletsActivites = new ArrayList<OngletActivite>();
		return ongletsActivites;
	}

	private void initOngletsActivites() {

		for (int i = 0; i < getSequence().getSeances().size(); i++) {
			addOngletsActivites(new OngletActivite(this));
		}

	}

	public void addOngletsActivites(OngletActivite ongletsActivite) {
		getOngletsActivites().add(ongletsActivite);
	}

	public Sequence getSequence() {
		return sequence;
	}

	private void setSequence(Sequence sequence) {
		this.sequence = sequence;
	}

}
