package fr.paquet.ihm.gestionnaire.activite;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.commun.gestionnaire.UserObject;

public class GestionnaireTreeNodeActivite extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionnaireTreeNodeActivite(List<Activite_1> activites) {
		super();

		this.setUserObject(new UserObject(null, "Activités"));

		for (Activite_1 activite : activites) {
			this.add(new TableTreeNode(activite));
		}
	}

	public static class TableTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TableTreeNode(Activite_1 activite) {
			super();

			this.setUserObject(new UserObject(activite, activite.toString()));

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
