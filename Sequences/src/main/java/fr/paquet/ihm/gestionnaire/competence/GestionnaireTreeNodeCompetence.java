package fr.paquet.ihm.gestionnaire.competence;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;

public class GestionnaireTreeNodeCompetence extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionnaireTreeNodeCompetence(List<Competence> competences) {
		super();

		for (Competence competence : competences) {

			String text = competence.toString();
			this.setUserObject(new UserObject(text));

			for (CompetenceIntermediaire compInt : competence.getCompetencesIntermediaires()) {
				String textComp = compInt.toString();
				this.add(new TableTreeNode(textComp));
			}
		}

	}

	public static class TableTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TableTreeNode(String text) {
			super();
			this.setUserObject(new UserObject(text));

		}

		@Override
		public boolean isLeaf() {
			return true;
		}
	}

	public static class UserObject {
		private String text = null;

		public UserObject(String text) {
			super();
			this.text = text;
		}

		public String getText() {
			return text;
		}
	}

}
