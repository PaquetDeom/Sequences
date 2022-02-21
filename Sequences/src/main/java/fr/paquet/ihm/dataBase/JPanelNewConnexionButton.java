package fr.paquet.ihm.dataBase;

import javax.swing.JPanel;

import fr.paquet.ihm.commun.JPanelButtonAnnulOk;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;

public class JPanelNewConnexionButton extends JPanelButtonAnnulOk {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPanelNewConnexionButton(JPanelNewConnexion jPanelNewConnexion) {
		super(jPanelNewConnexion);

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

		this.btnAnnul = btnAnnul;
	}

	@Override
	public void setBtnOk(JButton btnOk) {

		this.btnOk = btnOk;
	}

}
