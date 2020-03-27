package fr.paquet.ihm.principal.sequence;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import fr.paquet.ihm.commun.CommunJPanelImg;

public class SequencePanelEnteteImg extends CommunJPanelImg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelEntete sequencePanelEntete = null;

	protected SequencePanelEnteteImg(BufferedImage image, SequencePanelEntete sequencePanelEntete) {
		super(image);

		// set des composants
		setSequencePanelEntete(sequencePanelEntete);
	}

	@Override
	protected void setJButton(JButton jButton) {

		jButton.setText("Image séquence");

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.jButton = jButton;
	}

	public SequencePanelEntete getSequencePanelEntete() {
		return sequencePanelEntete;
	}

	private void setSequencePanelEntete(SequencePanelEntete sequencePanelEntete) {
		this.sequencePanelEntete = sequencePanelEntete;
	}

}
