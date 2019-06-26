package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SequencePanelButtomCompJPanelJLabel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SequencePanelButtomCompJLabel> sequencePanelButtomCompJLabel = null;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompJPanelJLabel(SequencePanelButtomComp sequencePanelButtomComp) {
		super();

		// setteur des éléments
		setSequencePanelButtomComp(sequencePanelButtomComp);

		// Création du layout
		setLayout(new GridBagLayout());

		// attribut du panel

		// affichage des component
		affiche();

	}

	public void affiche() {

		int rows = 0;

		if (!getSequencePanelButtomCompJLabel().isEmpty()) {
			for (SequencePanelButtomCompJLabel a : getSequencePanelButtomCompJLabel()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		this.revalidate();

	}

	private void setSequencePanelButtomCompJLabels(List<SequencePanelButtomCompJLabel> sequencePanelButtomCompJLabels) {
		this.sequencePanelButtomCompJLabel = sequencePanelButtomCompJLabels;
	}

	private List<SequencePanelButtomCompJLabel> getSequencePanelButtomCompJLabel() {
		if (sequencePanelButtomCompJLabel == null)
			sequencePanelButtomCompJLabel = new ArrayList<SequencePanelButtomCompJLabel>();
		return sequencePanelButtomCompJLabel;
	}

	public void addSequencePanelButtomCompJLabel(SequencePanelButtomCompJLabel sequencePanelButtomCompJLabel) {
		getSequencePanelButtomCompJLabel().add(sequencePanelButtomCompJLabel);
	}

	private SequencePanelButtomComp getSequencePanelButtomComp() {
		return sequencePanelButtomComp;
	}

	private void setSequencePanelButtomComp(SequencePanelButtomComp sequencePanelButtomComp) {
		this.sequencePanelButtomComp = sequencePanelButtomComp;
	}

}
