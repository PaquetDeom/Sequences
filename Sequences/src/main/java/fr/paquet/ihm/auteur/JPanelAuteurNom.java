package fr.paquet.ihm.auteur;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.lang.reflect.Constructor;


import fr.paquet.ihm.commun.CommunJPanelHorizontalJLabelJTexField;
import fr.paquet.ihm.commun.JSearchDialog;

public class JPanelAuteurNom extends CommunJPanelHorizontalJLabelJTexField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelAuteurNom(String textLabel) {
		super(textLabel, null);
	}

	public JPanelAuteurNom(String textLabel, @SuppressWarnings("rawtypes") Class dialogClass) {
		super(textLabel, null, dialogClass);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Constructor<JSearchDialog> ctor;
		try {
			ctor = dialogClass.getConstructor(String.class);
			setDialog(ctor.newInstance(new Object[] { getText() }));
			dialog.addSelectListener(this);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void objectSelected(PropertyChangeEvent event) {
		setObject(event.getNewValue());
		setText(event.getNewValue().toString());
		((JSearchDialog) event.getSource()).removeSelectListener(this);
	}

}
