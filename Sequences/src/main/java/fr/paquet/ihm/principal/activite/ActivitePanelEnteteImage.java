package fr.paquet.ihm.principal.activite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import fr.paquet.ihm.commun.CommunJPanelImg;

public class ActivitePanelEnteteImage extends CommunJPanelImg {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelEntete activitePanelEntete = null;

	public ActivitePanelEnteteImage(BufferedImage image, ActivitePanelEntete activitePanelEntete) {
		super(image);

		// set des composants
		setActivitePanelEntete(activitePanelEntete);

	}

	@Override
	protected void setJButton(JButton jButton) {

		jButton.setText("Image activité");

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.jButton = jButton;
	}

	public ActivitePanelEntete getActivitePanelEntete() {
		return activitePanelEntete;
	}

	private void setActivitePanelEntete(ActivitePanelEntete activitePanelEntete) {
		this.activitePanelEntete = activitePanelEntete;
	}

}
