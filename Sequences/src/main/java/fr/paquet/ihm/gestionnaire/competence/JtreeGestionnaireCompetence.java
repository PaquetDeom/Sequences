package fr.paquet.ihm.gestionnaire.competence;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import fr.paquet.ihm.commun.gestionnaire.DataCellRenderer;
import fr.paquet.ihm.commun.gestionnaire.JTreeGestionnaire;
import fr.paquet.referentiel.Competence;

public class JtreeGestionnaireCompetence extends JTreeGestionnaire {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JtreeGestionnaireCompetence(List<Competence> competences) {
		super(competences);

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

	@SuppressWarnings("unchecked")
	@Override
	protected DefaultMutableTreeNode getRootNode() {

		if (rootNode == null)
			rootNode = new GestionnaireTreeNodeCompetence((List<Competence>) getObjects());
		return rootNode;

	}

}
