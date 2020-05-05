package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;

import fr.paquet.dataBase.Factory.referentiel.ReferentielFactory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.ouvrir.JPanelOpenSequence;
import fr.paquet.referentiel.Referentiel;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

public class JPanelNewSequenceReferentiel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JPanelOpenSequence jPanelOpenSequence = null;

	public JPanelNewSequenceReferentiel(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);
		addReferentiels(prepareData());

		// ajout du Layout
		setLayout(new GridBagLayout());

		// Attribut du panel

		// affichage des components
		add(new JLabel("Référentiel :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getListReferentiels(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	public JPanelNewSequenceReferentiel(JPanelOpenSequence jPanelOpenSequence) {
		super();

		// setteur des éléments
		setjPanelOpenSequence(jPanelOpenSequence);
		addReferentiels(prepareData());

		// ajout du Layout
		setLayout(new GridBagLayout());

		// Attribut du panel

		// affichage des components
		add(new JLabel("Référentiel :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(getListReferentiels(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	private List<Referentiel> prepareData() {

		try {
			@SuppressWarnings("unchecked")
			List<Referentiel> referentiels = (List<Referentiel>) new ReferentielFactory().findAll();
			return referentiels;
		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}
		return null;
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	private JComboBox<Referentiel> listReferentiels = null;

	public JComboBox<Referentiel> getListReferentiels() {
		if (listReferentiels == null)
			listReferentiels = new JComboBox<Referentiel>();

		return listReferentiels;
	}

	public Referentiel getReferentiel() {
		if (getListReferentiels().getSelectedItem() instanceof Referentiel == true)
			return (Referentiel) getListReferentiels().getSelectedItem();
		else
			return null;
	}

	public void addReferentiels(List<Referentiel> listReferentiels) {
		getListReferentiels().addItem(null);
		for (Referentiel ref : listReferentiels) {
			getListReferentiels().addItem(ref);
		}

	}

	public JPanelOpenSequence getjPanelOpenSequence() {
		return jPanelOpenSequence;
	}

	public void setjPanelOpenSequence(JPanelOpenSequence jPanelOpenSequence) {
		this.jPanelOpenSequence = jPanelOpenSequence;
	}

}
