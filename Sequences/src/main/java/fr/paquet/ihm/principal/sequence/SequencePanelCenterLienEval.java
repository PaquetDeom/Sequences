package fr.paquet.ihm.principal.sequence;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.paquet.ihm.commun.CommunStyle;

public class SequencePanelCenterLienEval extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SequencePanelCenter sequencePanelCenter = null;
	private JPanel sequencePanelCenterLienEvalTitre = null;
	private JPanel sequencePanelCenterLienEvalSaisi = null;

	public SequencePanelCenterLienEval(SequencePanelCenter sequencePanelCenter) {
		super();

		// set des Elements
		setSequencePanelCenter(sequencePanelCenter);
		setSequencePanelCenterLienEvalTitre(new JPanel());
		setSequencePanelCenterLienEvalSaisi(new JPanel());

		// Ajout du Layout
		setLayout(new GridBagLayout());

		// Ajout des Composants
		add(getSequencePanelCenterLienEvalTitre(), new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
		add(getSequencePanelCenterLienEvalSaisi(), new GridBagConstraints(0, 1, 1, 1, 0, 1, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
	}

	private JPanel getSequencePanelCenterLienEvalTitre() {
		return sequencePanelCenterLienEvalTitre;
	}

	private void setSequencePanelCenterLienEvalTitre(JPanel sequencePanelCenterLienEvalTitre) {

		// Ajout du Layout
		sequencePanelCenterLienEvalTitre.setLayout(new GridLayout(0, 2, 0, 0));

		// Attributs
		sequencePanelCenterLienEvalTitre.setBackground(CommunStyle.PANELTITLE.getColor());

		// Création des components
		JLabel label1 = new JLabel("Liens avec d'autres disciplines");
		label1.setHorizontalTextPosition(GridBagConstraints.CENTER);
		JLabel label2 = new JLabel("Mode d'évaluation");
		label2.setHorizontalTextPosition(GridBagConstraints.CENTER);

		// Ajout des Components
		add(label1);
		add(label2);

		this.sequencePanelCenterLienEvalTitre = sequencePanelCenterLienEvalTitre;
	}

	private JPanel getSequencePanelCenterLienEvalSaisi() {
		return sequencePanelCenterLienEvalSaisi;
	}

	private void setSequencePanelCenterLienEvalSaisi(JPanel sequencePanelCenterLienEvalSaisi) {

		// Ajout du Layout
		setLayout(new GridLayout(0, 2, 0, 0));

		// Création des Components
		JTextArea lienArea = new JTextArea();
		lienArea.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		JTextArea evalArea = new JTextArea();
		evalArea.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		// Ajout des Components
		add(lienArea);
		add(evalArea);

		this.sequencePanelCenterLienEvalSaisi = sequencePanelCenterLienEvalSaisi;
	}

	private SequencePanelCenter getSequencePanelCenter() {
		return sequencePanelCenter;
	}

	private void setSequencePanelCenter(SequencePanelCenter sequencePanelCenter) {
		this.sequencePanelCenter = sequencePanelCenter;
	}

}
