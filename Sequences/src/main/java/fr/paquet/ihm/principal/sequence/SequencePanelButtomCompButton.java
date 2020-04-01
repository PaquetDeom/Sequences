package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelButton;

public class SequencePanelButtomCompButton extends CommunJPanelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompButton(String titleButton, int column,
			SequencePanelButtomComp sequencePanelButtomComp) throws Exception {
		super(titleButton, column);

		// setteur des objets
		setSequencePanelButtomComp(sequencePanelButtomComp);

	}

	@SuppressWarnings("unused")
	private SequencePanelButtomComp getSequencePanelButtomComp() {
		return sequencePanelButtomComp;
	}

	private void setSequencePanelButtomComp(SequencePanelButtomComp sequencePanelButtomComp) {
		this.sequencePanelButtomComp = sequencePanelButtomComp;
	}

	@Override
	public void setButton(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					getSequencePanelButtomComp().addCompetence();
				} catch (Exception e) {
					e.printStackTrace();
				}

				getSequencePanelButtomComp().getSequencePanelButtomCompJPanelJlabel().affiche();
			}
		});
		this.button = button;
	}

}
