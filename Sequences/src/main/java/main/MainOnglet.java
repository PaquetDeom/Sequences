package main;

import java.util.*;

import javax.swing.*;

import fr.paquet.ihm.principal.activite.OngletActivite;
import fr.paquet.ihm.principal.sequence.OngletSequence;
import fr.paquet.sequence.SequenceVersion;

@SuppressWarnings("serial")
public class MainOnglet extends JTabbedPane {

	private OngletSequence ongletSequence = null;
	private List<OngletActivite> ongletsActivites = null;

	/**
	 * Constructeur de la class private car ne doit etre instanciee qu une fois<br/>
	 * 
	 * @throws Exception
	 * 
	 * 
	 */
	private MainOnglet() {
		super(SwingConstants.TOP);

		// attributs de l'onglet

	}

	private static MainOnglet mainOnglet = null;

	public static MainOnglet getUniqInstance() {
		if (mainOnglet == null)
			mainOnglet = new MainOnglet();
		return mainOnglet;
	}

	public void afficheVersion() {
		getOngletSequence().getSequencePanel().getsequencePanelVersion().affiche();

		for (OngletActivite oA : getOngletsActivites()) {
			oA.getActivitePanel().getsequencePanelVersion().affiche();
		}
	}

	public void removeAllOngletActivites() {
		ongletsActivites = null;
	}

	public void affiche() {

		removeAll();

		addTab("Séquence " + MainFrame.getUniqInstance().getSequenceVersion().getTitre(), getOngletSequence());

		if (!getOngletsActivites().isEmpty()) {
			for (OngletActivite Oa : getOngletsActivites()) {
				addTab(Oa.getActivitePanel().getTitre(), Oa);
			}
		}

		revalidate();
	}

	public void init(SequenceVersion sequence) throws Exception {

		this.removeAll();

		// setteur des component
		this.ongletsActivites = null;
		setOngletSequence(new OngletSequence(sequence));
		affiche();

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

	public void addOngletsActivites(OngletActivite ongletsActivite) {
		getOngletsActivites().add(ongletsActivite);
	}

}
