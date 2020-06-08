package fr.paquet.ihm.nouveau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class JDialogNewVersion extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequenceVersion sequenceVersionOld = null;

	public JDialogNewVersion(SequenceVersion sequenceVersionOld) {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Création d'une nouvelle version de séquence");
		setResizable(false);
		setSize(600, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);

		// setteur des elements
		setSequenceVersionOld(sequenceVersionOld);

		// ajout du panel
		setContentPane(getJPanelNewVersion());

		// listener
		getJPanelNewVersion().getjPanelNewSequenceButton().getBtnAnnul().addActionListener(this);
		getJPanelNewVersion().getjPanelNewSequenceButton().getBtnOk().addActionListener(this);

		setVisible(true);

	}

	private JPanelNewVersion jPanelNewVersion = null;

	public JPanelNewVersion getJPanelNewVersion() {
		if (jPanelNewVersion == null)
			jPanelNewVersion = new JPanelNewVersion(this);
		return jPanelNewVersion;
	}

	public SequenceVersion getSequenceVersionOld() {
		return sequenceVersionOld;
	}

	public void setSequenceVersionOld(SequenceVersion sequenceVersionOld) {
		this.sequenceVersionOld = sequenceVersionOld;
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Annuler"))
			this.dispose();
		else {

			try {
				SequenceVersion sV = new SequenceVersion(getSequenceVersionOld());
				sV.setClasse(
						(String) getJPanelNewVersion().getjPanelNewSequenceClasse().getComboBox().getSelectedItem());
				new SequenceVersionFactory().persist(sV);
				MainFrame.getUniqInstance().addPanel(sV);
				this.dispose();
			} catch (Exception e) {
				e.printStackTrace();
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}

		}

	}

}
