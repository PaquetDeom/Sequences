package fr.paquet.ihm.gestionnaire.savoir;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import fr.paquet.ihm.commun.gestionnaire.DataCellRenderer;
import fr.paquet.ihm.commun.gestionnaire.JTreeGestionnaire;
import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;
import fr.paquet.ihm.commun.gestionnaire.SelectionListener;
import fr.paquet.ihm.commun.gestionnaire.UserObject;
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

	@Override
	protected void fireSeclectionChanged(TreePath selectionPath) {
		Object[] data = selectionPath.getPath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) data[data.length - 1];
		if (node instanceof GestionnaireTreeNodeSavoir.TableTreeNode == false)
			return;

		UserObject object = (UserObject) node.getUserObject();
		SelectedEvent event = new SelectedEvent(this, object);
		for (SelectionListener listener : getSelectionListeners()) {
			listener.SelectionChange(event);
		}
	}

}
