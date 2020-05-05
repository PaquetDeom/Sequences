package fr.paquet.ihm.nouveau;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import fr.paquet.commun.TypeDiplome;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelNewSequenceClasse extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JPanelNewVersion jPanelNewVersion = null;

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

	public JPanelNewSequenceClasse(JPanelNewVersion jPanelNewVersion) {
		super();

		// set des composants
		setjPanelNewVersion(jPanelNewVersion);
		setComboBox(getjPanelNewVersion().getjDialogNewVersion().getSequenceVersionOld().getReferentiel().getDiplome()
				.getType());

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des éléments :
		affiche();

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

		if (getjPanelNewSequence().getjPanelNewSequenceReferentiel().getReferentiel() != null)
			setComboBox(
					getjPanelNewSequence().getjPanelNewSequenceReferentiel().getReferentiel().getDiplome().getType());
		affiche();

	}

	public JPanelNewVersion getjPanelNewVersion() {
		return jPanelNewVersion;
	}

	public void setjPanelNewVersion(JPanelNewVersion jPanelNewVersion) {
		this.jPanelNewVersion = jPanelNewVersion;
	}

}
