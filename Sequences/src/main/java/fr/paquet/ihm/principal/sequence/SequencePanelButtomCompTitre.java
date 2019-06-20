package fr.paquet.ihm.principal.sequence;

import fr.paquet.ihm.commun.CommunTitle;
import fr.paquet.ihm.commun.Title;

public class SequencePanelButtomCompTitre extends CommunTitle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomComp sequencePanelButtomComp = null;

	public SequencePanelButtomCompTitre(Title title, SequencePanelButtomComp sequencePanelButtomComp) {
		super(title);

		// ajout des objets
		setSequencePanelButtomComp(sequencePanelButtomComp);
		
	}

	private SequencePanelButtomComp getSequencePanelButtomComp() {
		return sequencePanelButtomComp;
	}

	private void setSequencePanelButtomComp(SequencePanelButtomComp sequencePanelButtomComp) {
		this.sequencePanelButtomComp = sequencePanelButtomComp;
	}
}
