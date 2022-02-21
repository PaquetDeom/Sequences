package fr.paquet.ihm.gestionnaire.activite.competence;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.referentiel.CompetenceIntermediaire;

public class GestionnaireTreeNodeCompetenceActivite extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionnaireTreeNodeCompetenceActivite(List<CompetenceIntermediaire> competenceIntermediaires) {
		super();

		this.setUserObject(new UserObject(null, "Compétences intermediaires"));

		for (CompetenceIntermediaire comp : competenceIntermediaires) {
			this.add(new TablesTreeNode(comp));
		}
	}

	public static class TablesTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TablesTreeNode(CompetenceIntermediaire comp) {
			super();

			this.setUserObject(new UserObject(comp, comp.toString()));

		}

		@Override
		public boolean isLeaf() {
			return true;
		}
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

}
