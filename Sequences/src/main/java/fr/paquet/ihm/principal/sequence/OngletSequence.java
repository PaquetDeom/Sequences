package fr.paquet.ihm.principal.sequence;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.ScrollPaneConstants;

import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;
import main.MainOnglet;

public class OngletSequence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555340311930007466L;

	/**
	 * Cree un nouvel onglet<br/>
	 * 
	 * @throws Exception
	 */
	public OngletSequence(SequenceVersion sequenceVersion) {

		super();

		// Ajout de l'onglet
		JScrollPane js = new JScrollPane(getSequencePanel());
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		MainOnglet.getUniqInstance().addTab("Séquence " + MainFrame.getUniqInstance().getSequenceVersion().getTitre(),
				js);

		// attribut de l'onglet

	}

	private SequencePanel sequencePanel = null;

	public SequencePanel getSequencePanel() {
		if (sequencePanel == null)
			sequencePanel = new SequencePanel(this);
		return sequencePanel;
	}

}
