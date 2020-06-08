package fr.paquet.ihm.ouvrir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.gestionnaire.sequence.JDialogGestionnaireOuvrir;
import main.MainFrame;

public class JDialogOpenSequence extends JDialog implements ActionListener, ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelOpenSequence jPanelOpenSequence = null;

	public JDialogOpenSequence() throws Exception {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Ouverture du gestionnaire de séquence");
		setResizable(false);
		setSize(600, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		

		// setteur des elements
		setJPanelOpenSequence(new JPanelOpenSequence(this));

		// ajout du panel
		setContentPane(getJPanelOpenSequence());

		// listener
		getJPanelOpenSequence().getJPanelOpenSequenceButton().getBtnAnnul().addActionListener(this);
		getJPanelOpenSequence().getJPanelOpenSequenceButton().getBtnOk().addActionListener(this);
		getJPanelOpenSequence().getRadioButton().addChangeListener(this);
		
		setVisible(true);
	}

	private JPanelOpenSequence getJPanelOpenSequence() {
		return jPanelOpenSequence;
	}

	private void setJPanelOpenSequence(JPanelOpenSequence JPanelOpenSequence) {
		this.jPanelOpenSequence = JPanelOpenSequence;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Annuler"))
			this.dispose();

		if (button.getText().equals("Ok")) {

			if (getJPanelOpenSequence().getjPanelNewSequenceReferentiel().getReferentiel() != null) {
				new JDialogGestionnaireOuvrir(
						getJPanelOpenSequence().getjPanelNewSequenceReferentiel().getReferentiel(), isQueMoi());
				this.dispose();
			} else
				new AlertWindow(AlertType.INFORMATION, "Veuillez sélectionner un référentiel");
		}

	}

	private boolean quemoi = false;

	private boolean isQueMoi() {
		return quemoi;
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		JRadioButton radio = (JRadioButton) event.getSource();
		this.quemoi = radio.isSelected();
	}

}
