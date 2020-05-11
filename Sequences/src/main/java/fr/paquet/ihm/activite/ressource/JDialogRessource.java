package fr.paquet.ihm.activite.ressource;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import fr.paquet.ihm.commun.JPanelListJLabelButton;
import main.MainFrame;

public class JDialogRessource extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanelListJLabelButton jpanelOrigin = null;

	public JDialogRessource(JPanelListJLabelButton jpanel) {
		super(MainFrame.getUniqInstance());

		// construction de la fenêtre
		setTitle("Ajout d'un nouveau document");
		setResizable(false);
		setSize(600, 140);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(false);
		setVisible(true);

		// setteur des elements
		setJpanelOrigin(jpanel);

		// ajout du panel
		setContentPane(getMainPanel());

		// listener
		getMainPanel().getPanelButton().getBtnValider().addActionListener(this);
		getMainPanel().getPanelButton().getBtnAnnuler().addActionListener(this);
	}

	private MainPanelActiviteRessource mainPanelActiviteRessource = null;

	private MainPanelActiviteRessource getMainPanel() {
		if (mainPanelActiviteRessource == null)
			mainPanelActiviteRessource = new MainPanelActiviteRessource(this);
		return mainPanelActiviteRessource;
	}

	private JPanelListJLabelButton getJpanelOrigin() {
		return jpanelOrigin;
	}

	private void setJpanelOrigin(JPanelListJLabelButton jpanelOrigin) {
		this.jpanelOrigin = jpanelOrigin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Valider")) {
			if (getMainPanel().getPanelText().getjTextField().getText() != null
					&& !getMainPanel().getPanelText().getjTextField().getText().equals(""))
				if (getMainPanel().getPanelUrl().getjTextField().getText() != null
						&& !getMainPanel().getPanelUrl().getjTextField().getText().equals(""))
					addRessource(getMainPanel().getPanelText().getjTextField().getText(),
							getMainPanel().getPanelUrl().getjTextField().getText());

				else
					addRessource(getMainPanel().getPanelText().getjTextField().getText(), null);
			this.dispose();

		}

	}

	private void addRessource(String text, String url) {
		getJpanelOrigin().addRessouce(text, url);
	}

}
