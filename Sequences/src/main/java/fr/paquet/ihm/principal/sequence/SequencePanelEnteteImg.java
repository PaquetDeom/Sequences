package fr.paquet.ihm.principal.sequence;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SequencePanelEnteteImg extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;
	private JButton buttonImage = null;

	public SequencePanelEnteteImg(SequencePanelEntete sPE) {
		super();

		// set des éléments
		setSequencePanelEntete(sPE);
		setButtonImage(new JButton("Image"));

		// ajout du Layout
		setLayout(new BorderLayout());

		// Ajout des Elements
		add(getButtonImage(), BorderLayout.CENTER);
		add(new JPanel(), BorderLayout.NORTH);
		add(new JPanel(), BorderLayout.SOUTH);
		add(new JPanel(), BorderLayout.EAST);
		add(new JPanel(), BorderLayout.WEST);

	}

	private SequencePanelEntete getSequencePanelEntete() {
		return sequencePanelEntete;
	}

	private void setSequencePanelEntete(SequencePanelEntete sequencePanelEntete) {
		this.sequencePanelEntete = sequencePanelEntete;
	}

	private JButton getButtonImage() {
		return buttonImage;
	}

	private void setButtonImage(JButton buttonImage) {

		buttonImage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.buttonImage = buttonImage;
	}

}
