package fr.paquet.ihm.gestionnaire.savoir;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;

public class GestionnaireTreeNodeSavoir extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GestionnaireTreeNodeSavoir(List<Savoir> savoirs) {
		super();

		this.setUserObject(new UserObject(null, "Savoirs"));

		for (Savoir sav : savoirs) {
			this.add(new TablesTreeNode(sav));
		}

	}

	public static class TablesTreeNode extends DefaultMutableTreeNode {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TablesTreeNode(Savoir savoir) {
			super();

			this.setUserObject(new UserObject(savoir, savoir.toString()));
			List<SavoirAssocie> savoirAssocies = savoir.getSavoirsAssocies();

			if (savoirAssocies != null && !savoirAssocies.isEmpty()) {
				for (SavoirAssocie savAs : savoirAssocies) {
					this.add(new TableTreeNode(savAs));
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

		public TableTreeNode(SavoirAssocie savAss) {
			super();

			this.setUserObject(new UserObject(savAss, savAss.toString()));
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
