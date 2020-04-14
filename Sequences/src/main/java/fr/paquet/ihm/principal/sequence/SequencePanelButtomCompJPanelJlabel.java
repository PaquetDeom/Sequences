package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class SequencePanelButtomCompJPanelJlabel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompJPanelJlabel(SequencePanelButtomComp sequencePanelButtomComp) {
		super();

		// setteur des elements
		setSequencePanelButtomComp(sequencePanelButtomComp);

		// création du layout
		setLayout(new GridBagLayout());

		// affichage des Component
		affiche();

		// attribut du panel

	}

	public void affiche() {

		int rows = 0;

		if (!getSequencePanelButtomCompJLabels().isEmpty()) {
			for (SequencePanelButtomCompJLabel a : getSequencePanelButtomCompJLabels()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		this.revalidate();
	}

	public SequencePanelButtomComp getSequencePanelButtomComp() {
		return sequencePanelButtomComp;
	}

	private void setSequencePanelButtomComp(SequencePanelButtomComp sequencePanelButtomComp) {
		this.sequencePanelButtomComp = sequencePanelButtomComp;
	}

	private List<SequencePanelButtomCompJLabel> sequencePanelButtomCompJLabels = null;

	public List<SequencePanelButtomCompJLabel> getSequencePanelButtomCompJLabels() {
		if (sequencePanelButtomCompJLabels == null)
			sequencePanelButtomCompJLabels = new ArrayList<SequencePanelButtomCompJLabel>();
		return sequencePanelButtomCompJLabels;
	}

	public void addSequencePanelButtomCompJLabel(SequencePanelButtomCompJLabel sequencePanelButtomCompJLabel) {
		getSequencePanelButtomCompJLabels().add(sequencePanelButtomCompJLabel);
	}

	public void addCompetence() throws Exception {
		addSequencePanelButtomCompJLabel(new SequencePanelButtomCompJLabel());

	}

}
