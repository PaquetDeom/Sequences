package fr.paquet.ihm.commun.competence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;

public class JDialogJtreeComp extends JTree implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CompetenceIntermediaire> competenceIntermediaires = null;

	public JDialogJtreeComp(List<CompetenceIntermediaire> competenceint) {
		super();

		// setteur de component
		setCompetenceIntermediaires(competenceint);

		DefaultMutableTreeNode racine = new DefaultMutableTreeNode(getCompetence().toString());

		for (int i = 0; i < getCompetenceIntermediaires().size(); i++) {

			DefaultMutableTreeNode noeud = new DefaultMutableTreeNode(getCompetenceIntermediaires().get(i).toString());

			racine.add(noeud);
		}

		setRootVisible(true);

	}

	private List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		return competenceIntermediaires;
	}

	private void setCompetenceIntermediaires(List<CompetenceIntermediaire> competenceIntermediaires) {
		this.competenceIntermediaires = competenceIntermediaires;
	}

	private Competence getCompetence() {
		return getCompetenceIntermediaires().get(0).getCompetence();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
