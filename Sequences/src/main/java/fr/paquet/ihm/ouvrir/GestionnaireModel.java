package fr.paquet.ihm.ouvrir;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import fr.paquet.sequence.Sequence;

public class GestionnaireModel implements TableModel {

	private List<Sequence> sequences = null;

	private void setSequences(List<Sequence> sequences) {
		this.sequences = sequences;
	}

	private List<Sequence> getSequences() {
		return sequences;
	}

	public GestionnaireModel(List<Sequence> sequences) {
		super();
		setSequences(sequences);

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO

	}

	@Override
	public Class<?> getColumnClass(int column) {

		if (column == 0)
			return Sequence.class;

		else
			return null;
	}

	@Override
	public int getColumnCount() {

		return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0)
			return "Titre de la Sequence";

		else
			return null;
	}

	@Override
	public int getRowCount() {

		return getSequences().size();
	}

	@Override
	public Object getValueAt(int line, int column) {

		Sequence Sequence = getSequences().get(line);
		if (column == 0)
			return Sequence;

		else
			return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

}
