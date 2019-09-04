package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import javax.swing.JTable;

import javax.swing.table.JTableHeader;

import fr.paquet.ihm.commun.Title;
import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;
import fr.paquet.ihm.style.StyleRowHeight;

public class SequencePanelButtomComp extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanel sequencePanel = null;
	private SequencePanelButtomCompButton sequencePanelButtomCompButton = null;
	private JTable sequencePanelCompTable = null;

	public SequencePanelButtomComp(SequencePanel sequencePanel) {
		super();

		// set des compposants
		setSequencePanel(sequencePanel);
		setSequencePanelButtomCompButton(
				new SequencePanelButtomCompButton("+ Compétence", Title.COMPETENCES.getcolumn(), this));

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Gestion de l'affichage

		add(getSequencePanelCompTableHeader(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_START,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelCompTable(), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getSequencePanelButtomCompButton(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// Attribut du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private JTableHeader getSequencePanelCompTableHeader() {

		JTableHeader header = getSequencePanelCompTable().getTableHeader();

		// attributs du header
		header.setBackground(StyleColor.PANELTITLE.getColor());
		header.setFont(StyleFont.TITLESEQ.getFont());

		return header;
	}

	public JTable getSequencePanelCompTable() {
		if (sequencePanelCompTable == null) {
			sequencePanelCompTable = new JTable(new SequenceCompTableModel());

			// attribut du JTable
			sequencePanelCompTable.setRowHeight(StyleRowHeight.COMPROWHEIGHT.getHeight());
			sequencePanelCompTable.setRowSelectionAllowed(false);
			sequencePanelCompTable.setColumnSelectionAllowed(false);
		}
		return sequencePanelCompTable;
	}

	private SequencePanelButtomCompButton getSequencePanelButtomCompButton() {
		return sequencePanelButtomCompButton;
	}

	private void setSequencePanelButtomCompButton(SequencePanelButtomCompButton sequencePanelButtomCompButton) {
		this.sequencePanelButtomCompButton = sequencePanelButtomCompButton;
	}

	public SequencePanel getSequencePanel() {
		return sequencePanel;
	}

	private void setSequencePanel(SequencePanel sequencePanel) {
		this.sequencePanel = sequencePanel;
	}

}
