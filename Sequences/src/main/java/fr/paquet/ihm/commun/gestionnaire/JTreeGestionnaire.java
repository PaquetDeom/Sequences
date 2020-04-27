package fr.paquet.ihm.commun.gestionnaire;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import fr.paquet.ihm.gestionnaire.competence.GestionnaireTreeNodeCompetence;

public abstract class JTreeGestionnaire extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JTree jtreeValues = new JTree();

	private List<? extends Object> objects = null;

	private void setObjects(List<? extends Object> objects) {
		this.objects = objects;
	}

	protected List<? extends Object> getObjects() {
		return objects;
	}

	public JTreeGestionnaire(List<? extends Object> objects) {
		super();

		// set des composants
		setObjects(objects);
		setNodes(getObjects());

		// ajout du JTree au scrollPane
		this.setViewportView(jtreeValues);

		// attributs du JScrollPane
		this.setPreferredSize(new Dimension(600, 400));
		this.setMinimumSize(new Dimension(600, 400));
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// listener du JTree
		jtreeValues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {

				if (jtreeValues.getSelectionPath() != null) {
					fireSeclectionChanged(jtreeValues.getSelectionPath());
				}
			}

		});
	}

	protected DefaultMutableTreeNode rootNode = null;

	protected abstract DefaultMutableTreeNode getRootNode();

	protected abstract void setNodes(List<? extends Object> objects);

	private List<SelectionListener> selectionListeners = null;

	public List<SelectionListener> getSelectionListeners() {
		if (selectionListeners == null)
			selectionListeners = new ArrayList<SelectionListener>();
		return selectionListeners;
	}

	public void addSelectionListeners(SelectionListener selectionListener) {
		getSelectionListeners().add(selectionListener);
	}

	public void removeSelectionListeners(SelectionListener selectionListener) {
		getSelectionListeners().remove(selectionListener);
	}

	private void fireSeclectionChanged(TreePath selectionPath) {
		Object[] data = selectionPath.getPath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) data[data.length - 1];
		if (node instanceof GestionnaireTreeNodeCompetence.TableTreeNode == false)
			return;

		UserObject object = (UserObject) node.getUserObject();
		SelectedEvent event = new SelectedEvent(this, object);
		for (SelectionListener listener : getSelectionListeners()) {
			listener.SelectionChange(event);
		}
	}

}
