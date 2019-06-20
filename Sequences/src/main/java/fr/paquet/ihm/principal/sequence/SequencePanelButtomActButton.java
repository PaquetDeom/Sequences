package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelButton;

public class SequencePanelButtomActButton extends CommunJPanelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomAct sequencePanelButtomAct = null;

	public SequencePanelButtomActButton(String titleButton, int column, SequencePanelButtomAct sequencePanelButtonAct) {
		super(titleButton, column);

		// setteur des objets
		setSequencePanelButtomAct(sequencePanelButtonAct);
	}

	private SequencePanelButtomAct getSequencePanelButtomAct() {
		return sequencePanelButtomAct;
	}

	private void setSequencePanelButtomAct(SequencePanelButtomAct sequencePanelButtomAct) {
		this.sequencePanelButtomAct = sequencePanelButtomAct;
	}

	@Override
	protected void setButton(JButton button) {

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				// TODO FENETRE DES COMPETENCES
				SequencePanelButtomActJLabel sPBCJ = new SequencePanelButtomActJLabel(getColumn());
				getSequencePanelButtomAct().addSequencePanelButtomActJLabel(sPBCJ);
				getSequencePanelButtomAct().affiche();

			}
		});
		this.button = button;
	}

}
