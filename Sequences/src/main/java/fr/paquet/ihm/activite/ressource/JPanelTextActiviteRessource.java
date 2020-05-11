package fr.paquet.ihm.activite.ressource;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import fr.paquet.ihm.commun.CommunJPanelHorizontalJLabelJTexField;

public class JPanelTextActiviteRessource extends CommunJPanelHorizontalJLabelJTexField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelTextActiviteRessource(MainPanelActiviteRessource mainPanelActiviteRessource) {
		super("Texte", mainPanelActiviteRessource);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	@Override
	public void objectSelected(PropertyChangeEvent o) {

	}

}
