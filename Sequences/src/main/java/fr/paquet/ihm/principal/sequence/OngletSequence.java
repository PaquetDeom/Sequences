package fr.paquet.ihm.principal.sequence;

import javax.swing.JComponent;

import main.MainOnglet;

public class OngletSequence extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555340311930007466L;

	private SequencePanel sequencePanel = null;
	private MainOnglet mainOnglet = null;

	/**
	 * Cree un nouvel onglet<br/>
	 */
	public OngletSequence(MainOnglet mainOnglet) {

		super();

		//setteur des components
		setSequencePanel(new SequencePanel(this));
		setMainOnglet(mainOnglet);

		// Ajout de l'onglet
		getMainOnglet().addTab("Séquence " + getMainOnglet().getSequence().getTitre(), getSequencePanel());

	}

	private SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	private void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

}
