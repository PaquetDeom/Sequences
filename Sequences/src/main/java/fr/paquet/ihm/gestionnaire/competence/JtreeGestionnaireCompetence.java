package fr.paquet.ihm.gestionnaire.competence;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import fr.paquet.ihm.commun.gestionnaire.DataCellRenderer;
import fr.paquet.ihm.commun.gestionnaire.JTreeGestionnaire;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;
import fr.paquet.ihm.commun.gestionnaire.SelectionListener;
import fr.paquet.ihm.commun.gestionnaire.UserObject;
import fr.paquet.referentiel.Competence;

public class JtreeGestionnaireCompetence extends JTreeGestionnaire {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JtreeGestionnaireCompetence(List<Competence> competences) {
		super(competences, null);

	}

	@Override
	protected void setNodes(List<? extends Object> objects) {

		if (objects == null) {
			getJTreeValue().setModel(null);
			return;
		}

		try {
			getJTreeValue().setModel(new DefaultTreeModel(getRootNode()));
			getJTreeValue().setCellRenderer(new DataCellRenderer(this));
		} catch (Exception e) {
			e.printStackTrace();
			getJTreeValue().setModel(null);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	protected DefaultMutableTreeNode getRootNode() {

		if (rootNode == null)
			rootNode = new GestionnaireTreeNodeCompetence((List<Competence>) getObjects());
		return rootNode;

	}

	@Override
	protected void fireSeclectionChanged(TreePath selectionPath) {
		Object[] data = selectionPath.getPath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) data[data.length - 1];
		if (node instanceof GestionnaireTreeNodeCompetence.TableTreeNode == false)
			return;

		UserObject object = (UserObject) node.getUserObject();
		SelectedEvent event = new SelectedEvent(this, object, node);
		for (SelectionListener listener : getSelectionListeners()) {
			listener.SelectionChange(event);
		}
	}

}
