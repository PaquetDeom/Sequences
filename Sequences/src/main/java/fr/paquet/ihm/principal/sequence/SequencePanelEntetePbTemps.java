package fr.paquet.ihm.principal.sequence;

import java.awt.GridLayout;

import javax.swing.*;

import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelEntetePbTemps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;

	public SequencePanelEntetePbTemps(SequencePanelEntete sPE) throws Exception {
		super();

		// set des objets
		setSequencePanelEntete(sPE);

		// Gestion du layout
		setLayout(new GridLayout(2, 1, 0, 0));

		// integration de PanelProblematique et PanelTemps
		add(getSequencePanelEntetePbTempsProblematique());
		add(getSequencePanelEntetePbTempsJSlider());

		// attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	public SequencePanelEntete getSequencePanelEntete() {
		return sequencePanelEntete;
	}

	private void setSequencePanelEntete(SequencePanelEntete sequencePanelEntete) {
		this.sequencePanelEntete = sequencePanelEntete;
	}

	private SequencePanelEntetePbTempsProblématique sequencePanelEntetePbTempsProblematique = null;

	private SequencePanelEntetePbTempsProblématique getSequencePanelEntetePbTempsProblematique() {
		if (sequencePanelEntetePbTempsProblematique == null)
			sequencePanelEntetePbTempsProblematique = new SequencePanelEntetePbTempsProblématique(this,
					"Problématique");
		return sequencePanelEntetePbTempsProblematique;
	}

	private SequencePanelEntetePbTempsJSlider sequencePanelEntetePbTempsJSlider = null;

	private SequencePanelEntetePbTempsJSlider getSequencePanelEntetePbTempsJSlider() {
		if (sequencePanelEntetePbTempsJSlider == null)
			sequencePanelEntetePbTempsJSlider = new SequencePanelEntetePbTempsJSlider(this);
		return sequencePanelEntetePbTempsJSlider;
	}
}
