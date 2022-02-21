package fr.paquet.ihm.principal.sequence;

import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.text.BadLocationException;

import fr.paquet.ihm.style.StyleBorder;
import main.MainFrame;

public class SequencePanelEntetePbTemps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;

	public SequencePanelEntetePbTemps(SequencePanelEntete sPE) throws BadLocationException {
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

	private SequencePanelEntetePbTempsProblematique sequencePanelEntetePbTempsProblematique = null;

	private SequencePanelEntetePbTempsProblematique getSequencePanelEntetePbTempsProblematique()
			throws BadLocationException {
		if (sequencePanelEntetePbTempsProblematique == null) {
			if (MainFrame.getUniqInstance().getSequenceVersion().getProblematique() == null)
				sequencePanelEntetePbTempsProblematique = new SequencePanelEntetePbTempsProblematique(this);
			else
				sequencePanelEntetePbTempsProblematique = new SequencePanelEntetePbTempsProblematique(
						MainFrame.getUniqInstance().getSequenceVersion().getProblematique(), this);
		}

		return sequencePanelEntetePbTempsProblematique;
	}

	private SequencePanelEntetePbTempsJSlider sequencePanelEntetePbTempsJSlider = null;

	private SequencePanelEntetePbTempsJSlider getSequencePanelEntetePbTempsJSlider() {
		if (sequencePanelEntetePbTempsJSlider == null)
			sequencePanelEntetePbTempsJSlider = new SequencePanelEntetePbTempsJSlider(this);
		return sequencePanelEntetePbTempsJSlider;
	}
}
