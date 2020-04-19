package fr.paquet.ihm.commun.gestionnaire;

import java.util.EventObject;

public class SelectedEvent extends EventObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object object = null;

	public SelectedEvent(Object source, Object object) {
		super(source);
		if (object == null)
			throw new NullPointerException();
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

}
