package fr.paquet.ihm.principal.sequence;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelEntetePbTempsJSlider extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntetePbTemps sequencePanelEntetePbTemps = null;
	private JPanel panelTitre = null;
	private JPanel panelSlider = null;
	private JPanel panelEtiquette = null;
	private JSlider slider = null;

	public SequencePanelEntetePbTempsJSlider(SequencePanelEntetePbTemps sequencePanelEntetePbTemps) {
		super();

		// setteur des Component
		setSequencePanelEntetePbTemps(sequencePanelEntetePbTemps);
		setSlider(new JSlider());
		setPanelTitre(new JPanel());
		setPanelEtiquette(new JPanel());
		setPanelSlider(new JPanel());

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Attribut du panel;
		setBorder(CommunStyle.BORDERTITLEAREA.getBorder());

		// Gestion de l'affichage des component
		add(getPanelTitre(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 1, 0));

		add(getPanelEtiquette(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 1, 0));

		add(getPanelSlider(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 1, 0));

	}

	private SequencePanelEntetePbTemps getSequencePanelEntetePbTemps() {
		return sequencePanelEntetePbTemps;
	}

	private void setSequencePanelEntetePbTemps(SequencePanelEntetePbTemps sequencePanelEntetePbTemps) {
		this.sequencePanelEntetePbTemps = sequencePanelEntetePbTemps;
	}

	public JSlider getSlider() {
		return slider;
	}

	private void setSlider(JSlider slider) {

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.slider = slider;
	}

	private JPanel getPanelSlider() {
		return panelSlider;
	}

	private void setPanelSlider(JPanel panelSlider) {
		this.panelSlider = panelSlider;
	}

	private JPanel getPanelTitre() {
		return panelTitre;
	}

	private void setPanelTitre(JPanel panelTitre) {

		// ajout du layout
		panelTitre.setLayout(new FlowLayout());

		// Attribut du panel
		panelTitre.setBorder(CommunStyle.BORDERTITLEAREA.getBorder());
		panelTitre.setBackground(CommunStyle.PANELTITLE.getColor());

		// Création du label
		JLabel titreLabel = new JLabel("Positionnement sur l'année");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// Ajout des component au panel
		panelTitre.add(titreLabel);

		this.panelTitre = panelTitre;
	}

	private JPanel getPanelEtiquette() {
		return panelEtiquette;
	}

	private void setPanelEtiquette(JPanel panelTempsEtiquette) {

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

		this.panelEtiquette = panelTempsEtiquette;
	}

}
