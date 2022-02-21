package fr.paquet.ihm.gestionnaire.savoir;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.ButtomPanel;
import fr.paquet.referentiel.SavoirAssocie;

public class ButtomPanelSavoir extends ButtomPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ButtomPanelSavoir(JDialogSavoir jDialogSavoir) {
		super(jDialogSavoir);

	}

	private SavoirAssocie savAssSelected = null;

	@Override
	public void valueChanged(ListSelectionEvent event) {
		DefaultListSelectionModel dLSM = (DefaultListSelectionModel) event.getSource();
		int i = dLSM.getMinSelectionIndex();
		this.savAssSelected = getJDialogSavoir().getSavAssSelect().get(i);

	}

	private JDialogSavoir getJDialogSavoir() {

		return (JDialogSavoir) getjDialogGestion();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (getSavoirAssSelected() == null)
			new AlertWindow(AlertType.ATTENTION, "Veuillez selectionner un savoir");
		else {
			if (button.getText().equals("Supprimer")) {
				getJDialogSavoir().getSavAssSelect().remove(getSavoirAssSelected());
				affiche();
			}
		}
	}

	private SavoirAssocie getSavoirAssSelected() {
		return savAssSelected;
	}

	@Override
	public Object getListValue(Object object, int columnIndex) {
		SavoirAssocie savAss = (SavoirAssocie) object;
		switch (columnIndex) {
		case 0:
			return savAss.toString();
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getValues() {

		return getJDialogSavoir().getSavAssSelect();
	}

	@Override
	public String[] getColumnsName() {

		return new String[] { "Savoirs Associes" };
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getColumnsClass() {

		return new Class[] { String.class };
	}

	@Override
	protected void setButtons(List<JButton> buttons) {
		buttons.add(new JButton("Supprimer"));

		this.buttons = buttons;

	}

}
