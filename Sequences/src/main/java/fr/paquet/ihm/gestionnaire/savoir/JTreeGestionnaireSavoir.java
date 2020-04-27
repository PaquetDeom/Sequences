package fr.paquet.ihm.gestionnaire.savoir;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import fr.paquet.ihm.commun.gestionnaire.DataCellRenderer;
import fr.paquet.ihm.commun.gestionnaire.JTreeGestionnaire;

import fr.paquet.referentiel.Savoir;

public class JTreeGestionnaireSavoir extends JTreeGestionnaire {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTreeGestionnaireSavoir(List<Savoir> savoirs) {
		super(savoirs);

	}

	@SuppressWarnings("unchecked")
	@Override
	protected DefaultMutableTreeNode getRootNode() {

		if (rootNode == null)
			rootNode = new GestionnaireTreeNodeSavoir((List<Savoir>) getObjects());
		return rootNode;

	}

	@Override
	protected void setNodes(List<? extends Object> objects) {

		if (objects == null) {
			jtreeValues.setModel(null);
			return;
		}

		try {
			jtreeValues.setModel(new DefaultTreeModel(getRootNode()));
			jtreeValues.setCellRenderer(new DataCellRenderer(this));
		} catch (Exception e) {
			e.printStackTrace();
			jtreeValues.setModel(null);
		}

	}

}
