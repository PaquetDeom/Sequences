package fr.paquet.ihm.principal.sequence;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SequencePanelEntetePbTemps extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;
	private JPanel panelProblematique = null;
	private JPanel panelTemps = null;
	private JPanel panelTempsEtiquette = null;
	private JTextArea problematiqueArea = null;
	private JSlider tempsSlider = null;

	public SequencePanelEntetePbTemps(SequencePanelEntete sPE) {
		super();

		// set des objets
		setSequencePanelEntete(sPE);
		setPanelProblematique(new JPanel());
		setPanelTemps(new JPanel());
		setPanelTempsEtiquette(new JPanel());
		setProblematiqueArea(new JTextArea());
		setTempsSlider(new JSlider());

		// Gestion du layout
		setLayout(new GridLayout(2, 1, 0, 0));

		// integration de PanelProblematique et PanelTemps
		add(getPanelProblematique());
		add(getPanelTemps());
	}

	private SequencePanelEntete getSequencePanelEntete() {
		return sequencePanelEntete;
	}

	private void setSequencePanelEntete(SequencePanelEntete sequencePanelEntete) {
		this.sequencePanelEntete = sequencePanelEntete;
	}

	private JPanel getPanelProblematique() {
		return panelProblematique;
	}

	private void setPanelProblematique(JPanel panelProblematique) {

		// Gestion du layout du panel
		panelProblematique.setLayout(new GridLayout(2, 0, 0, 0));

		// Ajout des elements
		JLabel label = new JLabel("Problématique");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelProblematique.add(label);
		panelProblematique.add(getProblematiqueArea());

		this.panelProblematique = panelProblematique;
	}

	private JPanel getPanelTemps() {
		return panelTemps;
	}

	private void setPanelTemps(JPanel panelTemps) {

		// Gestion du Layout
		panelTemps.setLayout(new GridLayout(3, 1, 0, 0));

		// Ajout des éléments
		JLabel label = new JLabel("Positionnement dans le tems");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelTemps.add(label);
		panelTemps.add(getTempsSlider());
		panelTemps.add(getPanelTempsEtiquette());

		this.panelTemps = panelTemps;
	}

	public JTextArea getProblematiqueArea() {
		return problematiqueArea;
	}

	private void setProblematiqueArea(JTextArea problematiqueArea) {

		problematiqueArea.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		this.problematiqueArea = problematiqueArea;
	}

	public JSlider getTempsSlider() {
		return tempsSlider;
	}

	private void setTempsSlider(JSlider tempsSlider) {

		tempsSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.tempsSlider = tempsSlider;
	}

	private JPanel getPanelTempsEtiquette() {
		return panelTempsEtiquette;
	}

	private void setPanelTempsEtiquette(JPanel panelTempsEtiquette) {

		// ajout du layout
		panelTempsEtiquette.setLayout(new GridLayout(0, 5, 0, 0));

		// création des JLabel
		JLabel labelP1 = new JLabel("P1");
		JLabel labelP2 = new JLabel("P2");
		JLabel labelP3 = new JLabel("P3");
		JLabel labelP4 = new JLabel("P4");
		JLabel labelP5 = new JLabel("P5");

		labelP1.setHorizontalAlignment(SwingConstants.CENTER);
		labelP2.setHorizontalAlignment(SwingConstants.CENTER);
		labelP3.setHorizontalAlignment(SwingConstants.CENTER);
		labelP4.setHorizontalAlignment(SwingConstants.CENTER);
		labelP5.setHorizontalAlignment(SwingConstants.CENTER);

		// ajout des composants
		panelTempsEtiquette.add(labelP1);
		panelTempsEtiquette.add(labelP2);
		panelTempsEtiquette.add(labelP3);
		panelTempsEtiquette.add(labelP4);
		panelTempsEtiquette.add(labelP5);

		this.panelTempsEtiquette = panelTempsEtiquette;
	}
}
