package fr.paquet.ihm.principal.activite;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;
import fr.paquet.ihm.style.StyleFont;

public class ActivitePanelCorpsDroite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelCorps activitePanelCorps = null;

	public ActivitePanelCorpsDroite(ActivitePanelCorps activitePanelCorps) {
		super();

		// set des composants
		setActivitePanelCorps(activitePanelCorps);

		// affichage des composant
		affiche();

		// attribut du panel
		this.setBorder(StyleBorder.BORDERPANEL.getBorder());

	}

	private void affiche() {

		// ajout du Layout
		setLayout(new GridLayout(1, 6, 0, 0));

		int i = getLabelCorps().size();

		for (int a = 0; a < 6; a++) {

			while (a < i) {

				JLabel j = getLabelCorps().get(a);
				j.setFont(StyleFont.TITLECORPS.getFont());
				j.setHorizontalTextPosition(SwingConstants.CENTER);
				j.setVerticalTextPosition(SwingConstants.CENTER);

				JPanel panel = new JPanel();
				panel.setBackground(StyleColor.PANELSUPINT.getColor());
				panel.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
				panel.add(j);

				this.add(panel);
				a++;
			}

			JLabel j = new JLabel(" ");

			JPanel panel = new JPanel();
			panel.setBackground(StyleColor.PANELSUPINT.getColor());
			panel.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
			panel.add(j);

			this.add(panel);

		}

		this.revalidate();

	}

	private List<JLabel> labelCorps = null;

	private List<JLabel> getLabelCorps() {
		if (labelCorps == null)
			labelCorps = new ArrayList<JLabel>();
		return labelCorps;
	}

	public void addLabelCorps(JLabel label) {
		getLabelCorps().add(label);
	}

	public ActivitePanelCorps getActivitePanelCorps() {
		return activitePanelCorps;
	}

	private void setActivitePanelCorps(ActivitePanelCorps activitePanelCorps) {
		this.activitePanelCorps = activitePanelCorps;
	}

}
