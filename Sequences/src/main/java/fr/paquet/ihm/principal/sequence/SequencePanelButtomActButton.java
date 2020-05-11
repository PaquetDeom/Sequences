package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.CommunJPanelButton;
import main.MainFrame;
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

	public SequencePanelButtomAct getSequencePanelButtomAct() {
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

					if (MainFrame.getUniqInstance().getSequenceVersion()
							.isModifiable(Connect.getPConnexion().getUser().getAuteur())) {

						new Activite_1(MainFrame.getUniqInstance().getSequenceVersion());

						MainOnglet.getUniqInstance().affiche();
					} else
						new AlertWindow(AlertType.ATTENTION, "La séquence n'est pas modifiable");
				} catch (Exception e) {
					new AlertWindow(AlertType.ERREUR, "L'activité n'a pas été crée");
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

}
