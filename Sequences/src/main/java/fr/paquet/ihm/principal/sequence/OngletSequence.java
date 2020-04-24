package fr.paquet.ihm.principal.sequence;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;

import main.MainOnglet;

public class OngletSequence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555340311930007466L;

	private MainOnglet mainOnglet = null;

	/**
	 * Cree un nouvel onglet<br/>
	 * 
	 * @throws Exception
	 */
	public OngletSequence(MainOnglet mainOnglet) {

		super();

		// setteur des components
		setMainOnglet(mainOnglet);

		// Ajout de l'onglet
		JScrollPane js = new JScrollPane(getSequencePanel());
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getMainOnglet().addTab("Séquence " + getMainOnglet().getSequence().getTitre(), js);

		// attribut de l'onglet

	}

	private SequencePanel sequencePanel = null;

	public SequencePanel getSequencePanel() {
		if (sequencePanel == null)
			sequencePanel = new SequencePanel(this);
		return sequencePanel;
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	private void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

}
