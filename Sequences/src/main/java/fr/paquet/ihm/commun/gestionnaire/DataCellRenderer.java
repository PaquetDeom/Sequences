package fr.paquet.ihm.commun.gestionnaire;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;


import fr.paquet.ihm.style.StyleColor;

public class DataCellRenderer extends  DefaultTreeCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel nodeLabel = new JLabel();

	public DataCellRenderer(JTreeGestionnaire jTreeGestionnaire) {
		super();

		this.setBackgroundSelectionColor(StyleColor.PANELTITLESUPPORT.getColor());
	}

	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object node, boolean selected, boolean expanded,
			boolean leaf, int row, boolean hasFocus) {

		UserObject data = (UserObject) ((DefaultMutableTreeNode) node).getUserObject();
		nodeLabel.setText(data.getText());
		return nodeLabel;
	}

}
