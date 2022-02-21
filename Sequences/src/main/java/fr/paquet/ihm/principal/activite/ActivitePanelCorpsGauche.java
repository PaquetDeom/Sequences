package fr.paquet.ihm.principal.activite;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class ActivitePanelCorpsGauche extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCorps activitePanelCorps = null;
	private JButton jButton = null;

	public ActivitePanelCorpsGauche(ActivitePanelCorps activitePanelCorps) {
		super();

		// set des composants
		setActivitePanelCorps(activitePanelCorps);
		setjButton(new JButton("Choix"));

		// Ajout du Layout
		setLayout(new GridLayout(1, 2, 0, 0));

		// Ajout des composants
		add(getJpanelTitre());
		add(getjButton());

		// attribut du Panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private JPanel getJpanelTitre() {

		JPanel panel = new JPanel();

		// attribut du panel
		panel.setBackground(StyleColor.PANELCORPS.getColor());

		// composant du panel
		JLabel lblCorpsDetatConcerns = new JLabel("CORPS D'ETAT CONCERNÉS");
		lblCorpsDetatConcerns.setFont(StyleFont.TITLECORPS.getFont());
		lblCorpsDetatConcerns.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorpsDetatConcerns.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(lblCorpsDetatConcerns);

		return panel;
	}

	public ActivitePanelCorps getActivitePanelCorps() {
		return activitePanelCorps;
	}

	public void setActivitePanelCorps(ActivitePanelCorps activitePanelCorps) {
		this.activitePanelCorps = activitePanelCorps;
	}

	public JButton getjButton() {
		return jButton;
	}

	public void setjButton(JButton jButton) {

		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.jButton = jButton;
	}

}
