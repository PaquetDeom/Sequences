package fr.paquet.ihm.principal.activite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.paquet.ihm.commun.JPanelActiviteProfEleve;
import fr.paquet.ihm.commun.JScollPaneCommunEleveProf;

public class JSrollPaneEleve extends JScollPaneCommunEleveProf {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JSrollPaneEleve(JSplitPaneActProFEleve jSplitPaneActProFEleve) {
		super("Activités élèves");
		
		setVisible(true);
	}

	@Override
	public void setjButtonAdd(JButton jButtonAdd) {
		jButtonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanelActiviteProfEleve jPanelActiviteProfEleve = new JPanelActiviteProfEleve();
				addjPanelActiviteProfEleves(jPanelActiviteProfEleve);
				affiche();
			}
		});
		this.jButtonAdd = jButtonAdd;

	}

}
