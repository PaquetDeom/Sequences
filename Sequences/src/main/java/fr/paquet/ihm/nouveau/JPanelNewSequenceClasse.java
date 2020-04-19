package fr.paquet.ihm.nouveau;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import fr.paquet.commun.Diplome;
import fr.paquet.commun.TypeDiplome;
import fr.paquet.referentiel.Referentiel;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JPanelNewSequenceClasse extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;

	public JPanelNewSequenceClasse(JPanelNewSequence jPanelNewSequence) {
		super();

		// set des composants
		setjPanelNewSequence(jPanelNewSequence);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des éléments :
		affiche();

		// listener
		getjPanelNewSequence().getjPanelNewSequenceReferentiel().getListReferentiels().addActionListener(this);

	}

	public void setComboBox(TypeDiplome type) {

		JComboBox<String> comboBox = new JComboBox<String>();

		for (String a : type.getClasse()) {
			comboBox.addItem(a);
		}
		this.comboBox = comboBox;
	}

	private JComboBox<String> comboBox = new JComboBox<String>();

	public JComboBox<String> getComboBox() {

		return comboBox;
	}

	public void affiche() {

		removeAll();
		
		add(new JLabel("Classe concernée :"), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		if (getComboBox() != null)
			add(getComboBox(), new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		else {
			add(new JLabel("Attente de référentiel"), new GridBagConstraints(1, 0, 1, 1, 1, 0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		}
		
		revalidate();

	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		@SuppressWarnings("unchecked")
		JComboBox<Referentiel> jC = (JComboBox<Referentiel>) event.getSource();
		Referentiel ref = (Referentiel) jC.getSelectedItem();
	

		setComboBox(ref.getDiplome().getType());
		affiche();

	}

}
