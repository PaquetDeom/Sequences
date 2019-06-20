package fr.paquet.ihm.principal.sequence;

import fr.paquet.ihm.commun.CommunTitle;
import fr.paquet.ihm.commun.Title;

public class SequencePanelButtomActTitre extends CommunTitle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelButtomAct sequencePanelButtomAct = null;

	public SequencePanelButtomActTitre(Title title, SequencePanelButtomAct sequencePanelButtomAct) {
		super(title);
		
		//ajout des objets
		setSequencePanelButtomAct(sequencePanelButtomAct);
	}

	private SequencePanelButtomAct getSequencePanelButtomAct() {
		return sequencePanelButtomAct;
	}

	private void setSequencePanelButtomAct(SequencePanelButtomAct sequencePanelButtomAct) {
		this.sequencePanelButtomAct = sequencePanelButtomAct;
	}

}
