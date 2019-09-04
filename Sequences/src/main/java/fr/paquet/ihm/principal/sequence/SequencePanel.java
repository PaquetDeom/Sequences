package fr.paquet.ihm.principal.sequence;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.Scrollable;

public class SequencePanel extends JPanel implements Scrollable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OngletSequence ongletSequence = null;

	public SequencePanel(OngletSequence ongletSequence) {
		super();

		// set des composants
		setOngletSequence(ongletSequence);

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des composants
		add(new SequencePanelEntete(this), new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new SequencePanelButtomComp(this), new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new SequencePanelCenter(this), new GridBagConstraints(0, 2, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(new SequencePanelButtomAct(this), new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {

		return getPreferredSize();
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle arg0, int arg1, int arg2) {

		return 10;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {

		return true;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle arg0, int arg1, int arg2) {

		return 10;
	}

	public OngletSequence getOngletSequence() {
		return ongletSequence;
	}

	private void setOngletSequence(OngletSequence ongletSequence) {
		this.ongletSequence = ongletSequence;
	}

}
