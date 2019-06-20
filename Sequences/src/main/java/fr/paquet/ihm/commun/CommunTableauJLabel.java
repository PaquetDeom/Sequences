package fr.paquet.ihm.commun;

import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;

public class CommunTableauJLabel extends JPanel {

	public class CommunLabel extends JLabel implements JLabelValue {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CommunLabel(int i) {
			super();
			setHorizontalAlignment(SwingConstants.CENTER);
		}

		@Override
		public String getValue(int column) {
			// TODO Auto-generated method stub
			return null;
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int columns = 0;
	private HashMap<Integer, CommunLabel> jLabels = null;

	public CommunTableauJLabel(int columns) {
		super();

		setColumns(columns);

		// ajout du layout
		setLayout(new GridLayout(getColumns(), 0, 0, 0));

		for (int i = 0; i < getColumns(); i++) {
			CommunLabel communLabel = new CommunLabel(i);
			getjLabels().put(i, communLabel);
			add(communLabel);
		}

	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public HashMap<Integer, CommunLabel> getjLabels() {
		if (jLabels == null)
			jLabels = new HashMap<Integer, CommunLabel>();
		return jLabels;
	}

}
