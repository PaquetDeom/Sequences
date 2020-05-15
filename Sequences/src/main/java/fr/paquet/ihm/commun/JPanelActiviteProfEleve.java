package fr.paquet.ihm.commun;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import fr.paquet.ihm.principal.activite.JPanelActiviteEleve;
import fr.paquet.ihm.principal.activite.JPanelActiviteProf;
import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.ihm.style.StyleColor;

public class JPanelActiviteProfEleve extends JPanel implements ActionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextPane JtextDescription = null;
	private JComboBox<String> JComboTemps = null;
	private JButton buttonSuppr = null;
	private JPanelCommunEleveProf jPanelCommunEleveProf = null;

	public JPanelActiviteProfEleve(JPanelCommunEleveProf jPanelCommunEleveProf) {
		super();

		// ajout du layout
		setjPanelCommunEleveProf(jPanelCommunEleveProf);
		setLayout(new GridBagLayout());
		setJtextDescription(new JTextPane());
		setJComboTemps(new JComboBox<String>());
		setButtonSuppr(new JButton("suppr"));

		// ajout des composants
		add(getJtextDescription(), new GridBagConstraints(0, 0, 1, 3, 0.8, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getJPanelTitre(), new GridBagConstraints(1, 0, 1, 1, 0.2, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getJComboTemps(), new GridBagConstraints(1, 1, 1, 1, 0.2, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(getButtonSuppr(), new GridBagConstraints(1, 2, 1, 1, 0.2, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

		// attributs du panel
		setBorder(StyleBorder.BORDERTITLEAREA.getBorder());

		// Listener
		getButtonSuppr().addActionListener(this);
		addFocusListener(this);
	}

	private JPanel getJPanelTitre() {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
		panel.setBackground(StyleColor.PANELACTTITRE.getColor());

		JLabel label = new JLabel("durée");
		label.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(label, BorderLayout.CENTER);
		return panel;
	}

	public JTextPane getJtextDescription() {
		return JtextDescription;
	}

	private void setJtextDescription(JTextPane jtextDescription) {

		JtextDescription = jtextDescription;

	}

	public JButton getButtonSuppr() {
		return buttonSuppr;
	}

	private void setButtonSuppr(JButton buttonSuppr) {
		this.buttonSuppr = buttonSuppr;
	}

	public JComboBox<String> getJComboTemps() {
		return JComboTemps;
	}

	private void setJComboTemps(JComboBox<String> jComboTemps) {

		jComboTemps.addItem("5");
		jComboTemps.addItem("10");
		jComboTemps.addItem("15");
		jComboTemps.addItem("20");
		jComboTemps.addItem("25");
		jComboTemps.addItem("30");
		jComboTemps.addItem("35");
		jComboTemps.addItem("40");
		jComboTemps.addItem("45");
		jComboTemps.addItem("50");
		jComboTemps.addItem("55");

		JComboTemps = jComboTemps;
	}

	public JPanelCommunEleveProf getjPanelCommunEleveProf() {
		return jPanelCommunEleveProf;
	}

	private void setjPanelCommunEleveProf(JPanelCommunEleveProf jPanelCommunEleveProf) {
		this.jPanelCommunEleveProf = jPanelCommunEleveProf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (getjPanelCommunEleveProf() instanceof JPanelActiviteEleve == true)
			getjPanelCommunEleveProf().getActivite().getStrategie().getActiviteEleves()
					.remove(getjPanelCommunEleveProf().getActiviteStrategie());

		if (getjPanelCommunEleveProf() instanceof JPanelActiviteProf == true)
			getjPanelCommunEleveProf().getActivite().getStrategie().getActiviteProfs()
					.remove(getjPanelCommunEleveProf().getActiviteStrategie());

		getjPanelCommunEleveProf().removePanelActiviteProfEleve(this);

	}

	@Override
	public void focusGained(FocusEvent event) {

	}

	@Override
	public void focusLost(FocusEvent event) {

		getjPanelCommunEleveProf().getActiviteStrategie().setDescription(getJtextDescription().getText());

	}

}
