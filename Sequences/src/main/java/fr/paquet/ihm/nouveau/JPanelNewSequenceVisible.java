package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JCheckBox;
import java.awt.Insets;

public class JPanelNewSequenceVisible extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;
	private JCheckBox toutLeMondeBox = null;
	private JCheckBox queMoiBox = null;

	public JPanelNewSequenceVisible(JPanelNewSequence jPanelNewSequence) {
		super();

		// setteur des éléments
		setjPanelNewSequence(jPanelNewSequence);
		setToutLeMondeBox(new JCheckBox());
		setQueMoiBox(new JCheckBox());

		// ajout du layout
		setLayout(new GridBagLayout());

		// Affichege des component
		add(new JLabel("Visibilité :"), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(getToutLeMondeBox(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(getQueMoiBox(), new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
	}

	public JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	public JCheckBox getToutLeMondeBox() {
		return toutLeMondeBox;
	}

	private void setToutLeMondeBox(JCheckBox toutLeMondeBox) {
		toutLeMondeBox.setText("Tout le monde");

		toutLeMondeBox.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (toutLeMondeBox.isSelected())
					getQueMoiBox().setSelected(false);

			}
		});
		this.toutLeMondeBox = toutLeMondeBox;
	}

	public JCheckBox getQueMoiBox() {
		return queMoiBox;
	}

	private void setQueMoiBox(JCheckBox queMoiBox) {
		queMoiBox.setText("Que moi");

		queMoiBox.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (queMoiBox.isSelected())
					getToutLeMondeBox().setSelected(false);

			}
		});

		this.queMoiBox = queMoiBox;
	}

}
