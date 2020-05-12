package fr.paquet.ihm.principal.sequence;

import java.util.List;

import javax.swing.text.BadLocationException;

import fr.paquet.ihm.commun.JTableCompetences;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;

public class SequencePanelButtomCompCompSavoir extends JTableCompetences {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompCompSavoir(SequencePanelButtomComp sequencePanelButtomComp) throws BadLocationException {
		this(null,null,sequencePanelButtomComp);

	}

	public SequencePanelButtomCompCompSavoir(List<CompetenceIntermediaire> competenceIntermediaires,
			List<SavoirAssocie> savoirAssocies, SequencePanelButtomComp sequencePanelButtomComp) throws BadLocationException {
		super(competenceIntermediaires, savoirAssocies);

		//set des composants
		setSequencePanelButtomComp(sequencePanelButtomComp);
	}

	public SequencePanelButtomComp getSequencePanelButtomComp() {
		return sequencePanelButtomComp;
	}

	private void setSequencePanelButtomComp(SequencePanelButtomComp sequencePanelButtomComp) {
		this.sequencePanelButtomComp = sequencePanelButtomComp;
	}

}
