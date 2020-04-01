package fr.paquet.ihm.nouveau;

import javax.swing.JPanel;

import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.JPanelButtonAnnulOk;
import fr.paquet.sequence.Sequence;
import main.MainFrame;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelNewSequenceButton extends JPanelButtonAnnulOk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelNewSequenceButton(JPanelNewSequence jPanelNewSequence) {
		super(jPanelNewSequence);

		// ajout du layout
		setLayout(new BorderLayout());

		// Affichage
		JPanel panelbtn = new JPanel();
		add(panelbtn, BorderLayout.SOUTH);
		panelbtn.setLayout(new GridLayout(0, 3, 0, 0));
		panelbtn.add(new JPanel());
		panelbtn.add(getBtnAnnul());
		panelbtn.add(getBtnOk());
	}

	@Override
	public void setjPanel(JPanel panel) {
		this.panel = panel;

	}

	@Override
	public void setBtnAnnul(JButton btnAnnul) {

		btnAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JPanelNewSequence jp = (JPanelNewSequence) getJPanel();
				jp.getjDialogNewSequence().dispose();

			}
		});
		this.btnAnnul = btnAnnul;
	}

	@Override
	public void setBtnOk(JButton btnOk) {

		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				JPanelNewSequence jp = (JPanelNewSequence) getJPanel();
				try {
					MainFrame.getUniqInstance()
							.addPanel(new Sequence(jp.getjPanelNewSequenceTitle().getTitre(), null, null, null));
					jp.getjDialogNewSequence().dispose();
				} catch (Exception e) {
					new AlertWindow(AlertType.ERREUR, e.getMessage());
					e.printStackTrace();
				}

			}
		});

		this.btnOk = btnOk;
	}

}
