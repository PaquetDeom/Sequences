package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelButton;
import fr.paquet.ihm.principal.activite.OngletActivite;

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
				try {
					getSequencePanelButtomAct().addActivite();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				getSequencePanelButtomAct().getSequencePanelButtomActJPanelJLabel().affiche();

				try {
					new OngletActivite(
							getSequencePanelButtomAct().getSequencePanel().getOngletSequence().getMainOnglet());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

}
