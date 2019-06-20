package fr.paquet.ihm.principal.sequence;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelEntetePbTemps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;
	private SequencePanelEntetePbTempsJSlider sequencePanelEntetePbTempsJSlider = null;
	private SequencePanelEntetePbTempsProblématique sequencePanelEntetePbTempsProblematique = null;

	public SequencePanelEntetePbTemps(SequencePanelEntete sPE) {
		super();

		// set des objets
		setSequencePanelEntete(sPE);
		setSequencePanelEntetePbTempsProblematique(new SequencePanelEntetePbTempsProblématique(this, "Problématique"));
		setSequencePanelEntetePbTempsJSlider(new SequencePanelEntetePbTempsJSlider(this));

		// Gestion du layout
		setLayout(new GridLayout(2, 1, 0, 0));

		// integration de PanelProblematique et PanelTemps
		add(getSequencePanelEntetePbTempsProblematique());
		add(getSequencePanelEntetePbTempsJSlider());

		// attribut du panel
		setBorder(CommunStyle.BORDER.getBorder());
	}

	private SequencePanelEntete getSequencePanelEntete() {
		return sequencePanelEntete;
	}

	private void setSequencePanelEntete(SequencePanelEntete sequencePanelEntete) {
		this.sequencePanelEntete = sequencePanelEntete;
	}

	private SequencePanelEntetePbTempsProblématique getSequencePanelEntetePbTempsProblematique() {
		return sequencePanelEntetePbTempsProblematique;
	}

	private void setSequencePanelEntetePbTempsProblematique(
			SequencePanelEntetePbTempsProblématique sequencePanelEntetePbTempsProblematique) {
		this.sequencePanelEntetePbTempsProblematique = sequencePanelEntetePbTempsProblematique;
	}

	private SequencePanelEntetePbTempsJSlider getSequencePanelEntetePbTempsJSlider() {
		return sequencePanelEntetePbTempsJSlider;
	}

	private void setSequencePanelEntetePbTempsJSlider(
			SequencePanelEntetePbTempsJSlider sequencePanelEntetePbTempsJSlider) {
		this.sequencePanelEntetePbTempsJSlider = sequencePanelEntetePbTempsJSlider;
	}
}
