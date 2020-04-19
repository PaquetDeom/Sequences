package fr.paquet.ihm.gestionnaire.competence;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import fr.paquet.ihm.commun.gestionnaire.SelectedEvent;
import fr.paquet.ihm.commun.gestionnaire.SelectionListener;
import fr.paquet.ihm.gestionnaire.competence.GestionnaireTreeNodeCompetence.UserObject;
import fr.paquet.referentiel.Competence;

public class JtreeGestionnaireCompetence extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTree jtreeValues = new JTree();

	public JtreeGestionnaireCompetence(List<Competence> competences) {
		super();

		// set des composants
		setCompetences(competences);

		// ajout du JTree au scrollPane
		this.setViewportView(jtreeValues);

		// attributs du JScrollPane
		this.setPreferredSize(new Dimension(300, 200));
		this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// listener du JTree
		jtreeValues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent mouseEvent) {

				fireSeclectionChanged(jtreeValues.getSelectionPath());

			}

		});
	}

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

	protected void setCompetences(List<Competence> competences) {
		if (competences == null) {
			jtreeValues.setModel(null);
			return;
		}

		try {
			GestionnaireTreeNodeCompetence rootNode = new GestionnaireTreeNodeCompetence(competences);
			jtreeValues.setModel(new DefaultTreeModel(rootNode));
			jtreeValues.expandRow(1);
		} catch (Exception e) {
			e.printStackTrace();
			jtreeValues.setModel(null);
		}

	}

	private void fireSeclectionChanged(TreePath selectionPath) {
		Object[] data = selectionPath.getPath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) data[data.length - 1];
		if (node instanceof GestionnaireTreeNodeCompetence.TableTreeNode == false)
			return;

		UserObject object = (UserObject) node.getUserObject();
		SelectedEvent event = new SelectedEvent(this, object.getText());
		for (SelectionListener listener : getSelectionListeners()) {
			listener.SelectionChange(event);
		}
	}

}
