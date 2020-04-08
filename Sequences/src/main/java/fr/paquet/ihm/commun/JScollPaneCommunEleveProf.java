package fr.paquet.ihm.commun;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.paquet.ihm.style.StyleColor;

public abstract class JScollPaneCommunEleveProf extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jPanelActivite = null;
	protected JButton jButtonAdd = null;
	protected List<JPanelActiviteProfEleve> jPanelActiviteProfEleves = null;

	public JScollPaneCommunEleveProf(String titre) {
		super();

		setJPanelActivite(new JPanel());
		setjButtonAdd(new JButton(new ImageIcon("./target/classes/images/btnajouter.jpg")));
		add(mainPanel(titre));

		setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	}

	private JPanel mainPanel(String titre) {
		JPanel panel = new JPanel(new GridBagLayout());

		panel.add(getJpanelTitre(titre), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(getPanelButton(), new GridBagConstraints(0, 1, 1, 1, 1.0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		panel.add(getJPanelActivite(), new GridBagConstraints(0, 2, 1, 1, 1, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		return panel;
	}

	private JPanel JpanelTitre = null;

	public JPanel getJpanelTitre(String titre) {
		if (JpanelTitre == null) {
			JpanelTitre = new JPanel(new GridBagLayout());
			JpanelTitre.add(new JLabel(titre), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			JpanelTitre.setBackground(StyleColor.PANELACTTITRE.getColor());
		}
		return JpanelTitre;
	}

	public JPanel getJPanelActivite() {
		return jPanelActivite;
	}

	private void setJPanelActivite(JPanel jPanelActivite) {

		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());

		int i = 0;
		if (getJPanelActiviteProfEleves().size() != 0) {

			for (JPanelActiviteProfEleve jP : getJPanelActiviteProfEleves()) {
				panel.add(jP, new GridBagConstraints(0, i, 1, 1, 1, 0, GridBagConstraints.CENTER,
						GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
				i++;
			}
		}
		panel.add(new JPanel(), new GridBagConstraints(0, i++, 1, 1, 1, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		this.jPanelActivite = jPanelActivite;
	}

	protected void affiche() {
		setJPanelActivite(new JPanel());
		this.repaint();
	}

	private JPanel PanelButton = null;

	private JPanel getPanelButton() {
		if (PanelButton == null) {
			PanelButton = new JPanel(new GridBagLayout());
			PanelButton.add(getjButtonAdd(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			PanelButton.add(new JPanel(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return PanelButton;
	}

	public JButton getjButtonAdd() {
		return jButtonAdd;
	}

	public abstract void setjButtonAdd(JButton jButtonAdd);

	protected void addjPanelActiviteProfEleves(JPanelActiviteProfEleve jPanelActiviteProfEleves) {
		getJPanelActiviteProfEleves().add(jPanelActiviteProfEleves);
	}

	public List<JPanelActiviteProfEleve> getJPanelActiviteProfEleves() {
		if (jPanelActiviteProfEleves == null)
			jPanelActiviteProfEleves = new ArrayList<JPanelActiviteProfEleve>();
		return jPanelActiviteProfEleves;
	}

}
