package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelButton;
import fr.paquet.ihm.commun.competence.JDialogCompetence;
import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Unite;

public class SequencePanelButtomCompButton extends CommunJPanelButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompButton(String titleButton, int column,
			SequencePanelButtomComp sequencePanelButtomComp) {
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
					new JDialogCompetence(getSequencePanelButtomComp().getSequencePanel()
							.getOngletSequence().getMainOnglet().getSequence().getReferentiel());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		this.button = button;
	}

}
