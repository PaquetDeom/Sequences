package fr.paquet.ihm.principal.sequence;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.paquet.ihm.commun.Title;

public class SequenceCompTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rowCount = 0;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowCount;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnName(int columnIndex) {

		List<String> titles = Title.COMPETENCES.getTitle();

		switch (columnIndex) {
		case 0:
			return titles.get(0);
		case 1:
			return titles.get(1);
		case 2:
			return titles.get(2);
		default:
			return "error";
		}
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
