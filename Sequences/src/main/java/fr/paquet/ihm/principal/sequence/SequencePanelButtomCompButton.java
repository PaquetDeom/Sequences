package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.CommunJPanelButton;
import fr.paquet.ihm.gestionnaire.competence.JDialogCompetence;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class SequencePanelButtomCompButton extends CommunJPanelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompButton(String titleButton, int column,
			SequencePanelButtomComp sequencePanelButtomComp) {
		super(titleButton);

		// setteur des objets
		setSequencePanelButtomComp(sequencePanelButtomComp);

	}

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

					SequenceVersion sequence = MainFrame.getUniqInstance().getSequenceVersion();

					if (sequence.isModifiable()) {
						new JDialogCompetence(sequence, getSequencePanelButtomComp().getSequencePanel());

					} else
						new AlertWindow(AlertType.INFORMATION, "Vous ne pouvez pas modifier cette séquence");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

}
