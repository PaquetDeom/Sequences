package fr.paquet.ihm.action;

import java.awt.event.ActionEvent;

import fr.paquet.sequence.Sequence;

public class ActionCompetences extends ActionBDA{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sequence sequence = null;

	public ActionCompetences() {
		super();
		putValue(NAME, getName());
		if (sequence == null)
			setEnabled(false);
	}
	
	public void setSequence(Sequence sequence) {
		if (sequence != null)
			setEnabled(true);
		this.sequence  = sequence;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getParentMenuName() {
		
		return "Outils";
	}

	@Override
	public String getName() {
		
		return "Gestion compétences";
	}

}
