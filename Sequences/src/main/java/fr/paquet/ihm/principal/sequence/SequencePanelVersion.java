package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import fr.paquet.ihm.style.StyleBorder;

public class SequencePanelVersion extends JPanel {

	/**
	 * 
	 * 
	 * private static final long serialVersionUID = 1L; private SequencePanel
	 * sequencePanel = null;
	 * 
	 * public SequencePanelVersion(SequencePanel sequencePanel) { super();
	 * 
	 * setSequencePanel(sequencePanel);
	 * 
	 * // ajout d'un layout setLayout(new GridBagLayout());
	 * 
	 * // Construction des JLabel getLabelNom(); getLabelVersion();
	 * getLabelAuteur();
	 * 
	 * // ajout des composants. JLabel label = new JLabel("Nom de la séquence : ");
	 * add(label, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
	 * GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
	 * 0, 0)); add(getLabelNom(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
	 * GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
	 * 0, 0)); add(new JLabel("Version N° : "), new GridBagConstraints(2, 0, 1, 1,
	 * 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,
	 * 0, 0, 0), 0, 0)); add(getLabelVersion(), new GridBagConstraints(3, 0, 1, 1,
	 * 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0,
	 * 0, 0, 0), 0, 0)); add(new JLabel("Nom de l'auteur : "), new
	 * GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
	 * GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
	 * add(getLabelAuteur(), new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
	 * GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
	 * 0, 0)); add(new JPanel(), new GridBagConstraints(5, 0, 1, 1, 1.0, 0.0,
	 * GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0),
	 * 0, 0));
	 * 
	 * // attributs du panel setBorder(StyleBorder.BORDERPANEL.getBorder()); }
	 * 
	 * private JLabel getLabelAuteur() { if
	 * (getSequencePanel().getOngletSequence().getMainOnglet().getSequence().getVersionSequence()
	 * .getAuteur() == null) return new JLabel(" | "); else return new
	 * JLabel(getSequencePanel().getOngletSequence().getMainOnglet().getSequence().getVersionSequence()
	 * .getAuteur().getNom() + " " +
	 * getSequencePanel().getOngletSequence().getMainOnglet().getSequence().getVersionSequence()
	 * .getAuteur().getPrenom() + " | ");
	 * 
	 * }
	 * 
	 * private JLabel getLabelVersion() { if
	 * (getSequencePanel().getOngletSequence().getMainOnglet().getSequence().getVersionSequence()
	 * == null) return new JLabel(" | "); else return new JLabel("N°" +
	 * getSequencePanel().getOngletSequence().getMainOnglet().getSequence()
	 * .getVersionSequence().getNVersion() + " | ");
	 * 
	 * }
	 * 
	 * private JLabel getLabelNom() {
	 * 
	 * if (getSequencePanel().getOngletSequence().getMainOnglet().getSequence() ==
	 * null) return new JLabel(" | "); else return new
	 * JLabel(getSequencePanel().getOngletSequence().getMainOnglet().getSequence().getTitre()
	 * + " | ");
	 * 
	 * }
	 * 
	 * public SequencePanel getSequencePanel() { return sequencePanel; }
	 * 
	 * private void setSequencePanel(SequencePanel sequencePanel) {
	 * this.sequencePanel = sequencePanel; }
	 */
}
