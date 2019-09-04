package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

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

		// setteur des components
		setSequencePanel(new SequencePanel(this));
		setMainOnglet(mainOnglet);

		// Ajout de l'onglet
		JScrollPane js = new JScrollPane(getSequencePanel());
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		getMainOnglet().addTab("Séquence " + getMainOnglet().getSequence().getTitre(), js);
		// getMainOnglet().setPreferredSize(new Dimension(800, 600));
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
