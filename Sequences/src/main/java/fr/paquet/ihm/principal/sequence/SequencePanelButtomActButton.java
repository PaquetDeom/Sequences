package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.CommunJPanelButton;
import fr.paquet.ihm.principal.activite.OngletActivite;
import main.MainOnglet;

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
					Activite_1 act = new Activite_1(
							MainOnglet.getUniqInstance().getOngletSequence().getSequenceVersion());
					new OngletActivite(act);
				} catch (Exception e) {
					new AlertWindow(AlertType.ERREUR, "L'activité n'a pas été crée");
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

}
