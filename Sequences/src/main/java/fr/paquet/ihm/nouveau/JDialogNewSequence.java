package fr.paquet.ihm.nouveau;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.sequence.SequenceFactory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.Sequence;
import main.MainFrame;

public class JDialogNewSequence extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelNewSequence jPanelNewSequence = null;

	public JDialogNewSequence() throws Exception {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Création d'une nouvelle séquence");
		setResizable(false);
		setSize(600, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// setteur des elements
		setjPanelNewSequence(new JPanelNewSequence(this));

		// ajout du panel
		setContentPane(getjPanelNewSequence());

		// listener
		getjPanelNewSequence().getjPanelNewSequenceButton().getBtnAnnul().addActionListener(this);
		getjPanelNewSequence().getjPanelNewSequenceButton().getBtnOk().addActionListener(this);

	}

	private JPanelNewSequence getjPanelNewSequence() {
		return jPanelNewSequence;
	}

	private void setjPanelNewSequence(JPanelNewSequence jPanelNewSequence) {
		this.jPanelNewSequence = jPanelNewSequence;
	}

	private Sequence createSequence() throws Exception {

		String titre = getjPanelNewSequence().getjPanelNewSequenceTitle().getTitre();
		Referentiel ref = (Referentiel) getjPanelNewSequence().getjPanelNewSequenceReferentiel().getListReferentiels()
				.getSelectedItem();
		String classe = (String) getjPanelNewSequence().getjPanelNewSequenceClasse().getComboBox().getSelectedItem();
		String visibilite = (String) getjPanelNewSequence().getjPanelNewSequenceVisible().getVisibleBox()
				.getSelectedItem();

		Boolean visi = true;
		if (visibilite.equals("Que moi"))
			visi = false;

		if (titre == null || titre.equals("") || ref == null || classe == null || classe.equals("")
				|| visibilite == null || visibilite.equals(""))
			throw new Exception("Veuillez compléter votre saisi");

		return new Sequence(titre, classe, visi, ref, Connect.getPConnexion().getUser().getAuteur(), 1);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Annuler"))
			this.dispose();
		else {

			try {
				Sequence seq = createSequence();
				new SequenceFactory().persist(seq);
				MainFrame.getUniqInstance().addPanel(seq);
				this.dispose();
			} catch (Exception e) {
				e.printStackTrace();
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}

		}

	}

}
