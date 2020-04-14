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

		// affichage des Component
		affiche();
		
		//attribut du panel
		
	}

	public void affiche() {

		int rows = 0;

		if (!getSequencePanelButtomActJLabels().isEmpty()) {
			for (SequencePanelButtomActJLabel a : getSequencePanelButtomActJLabels()) {

				add(a, new GridBagConstraints(0, rows, 1, 1, 1, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
				rows++;

			}
		}

		this.revalidate();
	}

	public SequencePanelButtomAct getSequencePanelButtomAct() {
		return sequencePanelButtomAct;
	}

	private void setSequencePanelButtomAct(SequencePanelButtomAct sequencePanelButtomAct) {
		this.sequencePanelButtomAct = sequencePanelButtomAct;
	}

	private List<SequencePanelButtomActJLabel> getSequencePanelButtomActJLabels() {
		if (sequencePanelButtomActJLabel == null)
			sequencePanelButtomActJLabel = new ArrayList<SequencePanelButtomActJLabel>();
		return sequencePanelButtomActJLabel;
	}

	public void addSequencePanelButtomActJLabel(SequencePanelButtomActJLabel sequencePanelButtomActJLabel) {
		getSequencePanelButtomActJLabels().add(sequencePanelButtomActJLabel);
	}

	
	public void addActivite() throws Exception {
		addSequencePanelButtomActJLabel(new SequencePanelButtomActJLabel());
	}

}
