package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SequencePanelButtomActJPanelJLabel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomAct sequencePanelButtomAct = null;
	private List<SequencePanelButtomActJLabel> sequencePanelButtomActJLabel = null;

	public SequencePanelButtomActJPanelJLabel(SequencePanelButtomAct sequencePanelButtomAct) {
		super();

		// setteur des elements
		setSequencePanelButtomAct(sequencePanelButtomAct);

		// création du layout
		setLayout(new GridBagLayout());

		// attribut du panel

		// affichage des Component
		affiche();
	}

	public void affiche() {

		int rows = 0;

		if (!getSequencePanelButtomActJLabel().isEmpty()) {
			for (SequencePanelButtomActJLabel a : getSequencePanelButtomActJLabel()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		this.revalidate();
	}

	private SequencePanelButtomAct getSequencePanelButtomAct() {
		return sequencePanelButtomAct;
	}

	private void setSequencePanelButtomAct(SequencePanelButtomAct sequencePanelButtomAct) {
		this.sequencePanelButtomAct = sequencePanelButtomAct;
	}

	private List<SequencePanelButtomActJLabel> getSequencePanelButtomActJLabel() {
		if (sequencePanelButtomActJLabel == null)
			sequencePanelButtomActJLabel = new ArrayList<SequencePanelButtomActJLabel>();
		return sequencePanelButtomActJLabel;
	}

	public void addSequencePanelButtomActJLabel(SequencePanelButtomActJLabel sequencePanelButtomActJLabel) {
		getSequencePanelButtomActJLabel().add(sequencePanelButtomActJLabel);
	}

	private void setSequencePanelButtomActJLabels(List<SequencePanelButtomActJLabel> sequencePanelButtomActJLabels) {
		this.sequencePanelButtomActJLabel = sequencePanelButtomActJLabels;
	}

}
