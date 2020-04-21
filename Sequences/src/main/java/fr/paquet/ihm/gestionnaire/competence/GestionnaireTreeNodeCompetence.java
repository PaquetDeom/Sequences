package fr.paquet.ihm.gestionnaire.competence;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;

public class GestionnaireTreeNodeCompetence extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionnaireTreeNodeCompetence(List<Competence> competences) {
		super();

		this.setUserObject(new UserObject(null, "Compétences"));

		for (Competence comp : competences) {
			this.add(new TablesTreeNode(comp));
		}
	}

	public static class TablesTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TablesTreeNode(Competence comp) {
			super();

			this.setUserObject(new UserObject(comp, comp.toString()));
			List<CompetenceIntermediaire> compInts = comp.getCompetencesIntermediaires();

			if (compInts != null && !compInts.isEmpty()) {
				for (CompetenceIntermediaire compInt : compInts) {
					this.add(new TableTreeNode(compInt));

				}

			}

		}

		@Override
		public boolean isLeaf() {
			return false;
		}
	}

	public static class TableTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TableTreeNode(CompetenceIntermediaire compInt) {
			super();

			this.setUserObject(new UserObject(compInt, compInt.toString()));

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
