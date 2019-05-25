package fr.paquet.ihm.principal.sequence;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;

import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JSlider;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Scrollable;

public class essai extends JPanel implements Scrollable {
	public essai() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);

		JPanel sequencePanel = new JPanel();
		GridBagConstraints gbc_sequencePanel = new GridBagConstraints();
		gbc_sequencePanel.fill = GridBagConstraints.BOTH;
		gbc_sequencePanel.gridx = 0;
		gbc_sequencePanel.gridy = 4;
		add(sequencePanel, gbc_sequencePanel);
		GridBagLayout gbl_sequencePanel = new GridBagLayout();
		gbl_sequencePanel.columnWidths = new int[] { 0, 0 };
		gbl_sequencePanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_sequencePanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_sequencePanel.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		sequencePanel.setLayout(gbl_sequencePanel);

		JPanel sequencePanelEntete = new JPanel();
		GridBagConstraints gbc_sequencePanelEntete = new GridBagConstraints();
		gbc_sequencePanelEntete.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelEntete.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelEntete.gridx = 0;
		gbc_sequencePanelEntete.gridy = 0;
		sequencePanel.add(sequencePanelEntete, gbc_sequencePanelEntete);
		GridBagLayout gbl_sequencePanelEntete = new GridBagLayout();
		gbl_sequencePanelEntete.columnWidths = new int[] { 0 };
		gbl_sequencePanelEntete.rowHeights = new int[] { 0 };
		gbl_sequencePanelEntete.columnWeights = new double[] { 1.0, 0.0 };
		gbl_sequencePanelEntete.rowWeights = new double[] { 1.0 };
		sequencePanelEntete.setLayout(gbl_sequencePanelEntete);

		JPanel sequencePanelEnteteImg = new JPanel();
		GridBagConstraints gbc_sequencePanelEnteteImg = new GridBagConstraints();
		gbc_sequencePanelEnteteImg.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelEnteteImg.insets = new Insets(0, 0, 0, 5);
		gbc_sequencePanelEnteteImg.gridx = 0;
		gbc_sequencePanelEnteteImg.gridy = 0;
		sequencePanelEntete.add(sequencePanelEnteteImg, gbc_sequencePanelEnteteImg);
		sequencePanelEnteteImg.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		sequencePanelEnteteImg.add(panel, BorderLayout.NORTH);

		JPanel panel_23 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_23.getLayout();
		flowLayout_3.setAlignOnBaseline(true);
		sequencePanelEnteteImg.add(panel_23, BorderLayout.SOUTH);

		JPanel panel_24 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_24.getLayout();
		flowLayout_2.setAlignOnBaseline(true);
		sequencePanelEnteteImg.add(panel_24, BorderLayout.WEST);

		JPanel panel_25 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_25.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		sequencePanelEnteteImg.add(panel_25, BorderLayout.EAST);

		JButton btnNewButton = new JButton("Image");
		sequencePanelEnteteImg.add(btnNewButton, BorderLayout.CENTER);

		JPanel sequencePanelEntetePbTemps = new JPanel();
		GridBagConstraints gbc_sequencePanelEntetePbTemps = new GridBagConstraints();
		gbc_sequencePanelEntetePbTemps.weightx = 1.0;
		gbc_sequencePanelEntetePbTemps.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelEntetePbTemps.gridx = 1;
		gbc_sequencePanelEntetePbTemps.gridy = 0;
		sequencePanelEntete.add(sequencePanelEntetePbTemps, gbc_sequencePanelEntetePbTemps);
		sequencePanelEntetePbTemps.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_3 = new JPanel();
		sequencePanelEntetePbTemps.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));

		JLabel label = new JLabel("Problématique");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(label);

		JTextArea textArea = new JTextArea();
		panel_3.add(textArea);

		JPanel panel_4 = new JPanel();
		sequencePanelEntetePbTemps.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 1, 0, 0));

		JLabel label_1 = new JLabel("Positionnement dans le temps");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label_1);

		JSlider slider = new JSlider();
		panel_4.add(slider);

		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 5, 0, 0));

		JLabel label_2 = new JLabel("P1");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_2.setBackground(new Color(255, 255, 204));
		panel_5.add(label_2);

		JLabel label_3 = new JLabel("P2");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_3.setBackground(new Color(255, 255, 153));
		panel_5.add(label_3);

		JLabel label_4 = new JLabel("P3");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_4.setBackground(new Color(255, 255, 102));
		panel_5.add(label_4);

		JLabel label_5 = new JLabel("P4");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_5.setBackground(new Color(255, 255, 51));
		panel_5.add(label_5);

		JLabel label_6 = new JLabel("P5");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_6.setBackground(Color.YELLOW);
		panel_5.add(label_6);

		JPanel sequencePanelCenter = new JPanel();
		GridBagConstraints gbc_sequencePanelCenter = new GridBagConstraints();
		gbc_sequencePanelCenter.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenter.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenter.gridx = 0;
		gbc_sequencePanelCenter.gridy = 1;
		sequencePanel.add(sequencePanelCenter, gbc_sequencePanelCenter);
		GridBagLayout gbl_sequencePanelCenter = new GridBagLayout();
		gbl_sequencePanelCenter.columnWidths = new int[] { 0, 0 };
		gbl_sequencePanelCenter.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_sequencePanelCenter.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_sequencePanelCenter.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		sequencePanelCenter.setLayout(gbl_sequencePanelCenter);

		JPanel sequencePanelCenterPrérequisTitre = new JPanel();
		sequencePanelCenterPrérequisTitre.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_sequencePanelCenterPrérequisTitre = new GridBagConstraints();
		gbc_sequencePanelCenterPrérequisTitre.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterPrérequisTitre.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenterPrérequisTitre.gridx = 0;
		gbc_sequencePanelCenterPrérequisTitre.gridy = 0;
		sequencePanelCenter.add(sequencePanelCenterPrérequisTitre, gbc_sequencePanelCenterPrérequisTitre);

		JLabel label_7 = new JLabel("Prérequis Elèves");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelCenterPrérequisTitre.add(label_7);

		JPanel sequencePanelCenterPrérequisSaisi = new JPanel();
		GridBagConstraints gbc_sequencePanelCenterPrérequisSaisi = new GridBagConstraints();
		gbc_sequencePanelCenterPrérequisSaisi.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterPrérequisSaisi.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenterPrérequisSaisi.gridx = 0;
		gbc_sequencePanelCenterPrérequisSaisi.gridy = 1;
		sequencePanelCenter.add(sequencePanelCenterPrérequisSaisi, gbc_sequencePanelCenterPrérequisSaisi);
		sequencePanelCenterPrérequisSaisi.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textArea_1 = new JTextArea();
		sequencePanelCenterPrérequisSaisi.add(textArea_1);

		JPanel sequencePanelCenterPrerequisTitre = new JPanel();
		sequencePanelCenterPrerequisTitre.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_sequencePanelCenterPrerequisTitre = new GridBagConstraints();
		gbc_sequencePanelCenterPrerequisTitre.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterPrerequisTitre.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenterPrerequisTitre.gridx = 0;
		gbc_sequencePanelCenterPrerequisTitre.gridy = 2;
		sequencePanelCenter.add(sequencePanelCenterPrerequisTitre, gbc_sequencePanelCenterPrerequisTitre);

		JLabel label_8 = new JLabel("Présentation du contexte professionnel");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelCenterPrerequisTitre.add(label_8);

		JPanel sequencePanelPrérequisSaisi = new JPanel();
		GridBagConstraints gbc_sequencePanelPrérequisSaisi = new GridBagConstraints();
		gbc_sequencePanelPrérequisSaisi.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelPrérequisSaisi.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelPrérequisSaisi.gridx = 0;
		gbc_sequencePanelPrérequisSaisi.gridy = 3;
		sequencePanelCenter.add(sequencePanelPrérequisSaisi, gbc_sequencePanelPrérequisSaisi);
		sequencePanelPrérequisSaisi.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textArea_2 = new JTextArea();
		sequencePanelPrérequisSaisi.add(textArea_2);

		JPanel sequencePanelElementsCenterTitre = new JPanel();
		sequencePanelElementsCenterTitre.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_sequencePanelElementsCenterTitre = new GridBagConstraints();
		gbc_sequencePanelElementsCenterTitre.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelElementsCenterTitre.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelElementsCenterTitre.gridx = 0;
		gbc_sequencePanelElementsCenterTitre.gridy = 4;
		sequencePanelCenter.add(sequencePanelElementsCenterTitre, gbc_sequencePanelElementsCenterTitre);

		JLabel label_9 = new JLabel("Eléments à retenir");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelElementsCenterTitre.add(label_9);

		JPanel sequencePanelElementsCenterSaisi = new JPanel();
		GridBagConstraints gbc_sequencePanelElementsCenterSaisi = new GridBagConstraints();
		gbc_sequencePanelElementsCenterSaisi.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelElementsCenterSaisi.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelElementsCenterSaisi.gridx = 0;
		gbc_sequencePanelElementsCenterSaisi.gridy = 5;
		sequencePanelCenter.add(sequencePanelElementsCenterSaisi, gbc_sequencePanelElementsCenterSaisi);
		sequencePanelElementsCenterSaisi.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea textArea_3 = new JTextArea();
		sequencePanelElementsCenterSaisi.add(textArea_3);

		JPanel sequencePanelCenterLienEval = new JPanel();
		GridBagConstraints gbc_sequencePanelCenterLienEval = new GridBagConstraints();
		gbc_sequencePanelCenterLienEval.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenterLienEval.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterLienEval.gridx = 0;
		gbc_sequencePanelCenterLienEval.gridy = 6;
		sequencePanelCenter.add(sequencePanelCenterLienEval, gbc_sequencePanelCenterLienEval);
		GridBagLayout gbl_sequencePanelCenterLienEval = new GridBagLayout();
		gbl_sequencePanelCenterLienEval.columnWidths = new int[] { 0, 0 };
		gbl_sequencePanelCenterLienEval.rowHeights = new int[] { 0, 0, 0 };
		gbl_sequencePanelCenterLienEval.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_sequencePanelCenterLienEval.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		sequencePanelCenterLienEval.setLayout(gbl_sequencePanelCenterLienEval);

		JPanel sequencePanelCenterLienEvalTitre = new JPanel();
		sequencePanelCenterLienEvalTitre.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_sequencePanelCenterLienEvalTitre = new GridBagConstraints();
		gbc_sequencePanelCenterLienEvalTitre.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterLienEvalTitre.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelCenterLienEvalTitre.gridx = 0;
		gbc_sequencePanelCenterLienEvalTitre.gridy = 0;
		sequencePanelCenterLienEval.add(sequencePanelCenterLienEvalTitre, gbc_sequencePanelCenterLienEvalTitre);
		sequencePanelCenterLienEvalTitre.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel label_10 = new JLabel("Liens avec d'autres disciplines");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelCenterLienEvalTitre.add(label_10);

		JLabel label_11 = new JLabel("Mode d'évaluation");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelCenterLienEvalTitre.add(label_11);

		JPanel sequencePanelCenterLienEvalSaisi = new JPanel();
		GridBagConstraints gbc_sequencePanelCenterLienEvalSaisi = new GridBagConstraints();
		gbc_sequencePanelCenterLienEvalSaisi.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelCenterLienEvalSaisi.gridx = 0;
		gbc_sequencePanelCenterLienEvalSaisi.gridy = 1;
		sequencePanelCenterLienEval.add(sequencePanelCenterLienEvalSaisi, gbc_sequencePanelCenterLienEvalSaisi);
		sequencePanelCenterLienEvalSaisi.setLayout(new GridLayout(0, 2, 0, 0));

		JTextArea textArea_4 = new JTextArea();
		sequencePanelCenterLienEvalSaisi.add(textArea_4);

		JTextArea textArea_5 = new JTextArea();
		sequencePanelCenterLienEvalSaisi.add(textArea_5);

		JPanel sequencePanelButtom = new JPanel();
		GridBagConstraints gbc_sequencePanelButtom = new GridBagConstraints();
		gbc_sequencePanelButtom.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelButtom.gridx = 0;
		gbc_sequencePanelButtom.gridy = 2;
		sequencePanel.add(sequencePanelButtom, gbc_sequencePanelButtom);
		GridBagLayout gbl_sequencePanelButtom = new GridBagLayout();
		gbl_sequencePanelButtom.columnWidths = new int[] { 546, 0 };
		gbl_sequencePanelButtom.rowHeights = new int[] { 15, 0, 0, 0 };
		gbl_sequencePanelButtom.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_sequencePanelButtom.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		sequencePanelButtom.setLayout(gbl_sequencePanelButtom);

		JPanel sequencePanelButtomTitre = new JPanel();
		sequencePanelButtomTitre.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_sequencePanelButtomTitre = new GridBagConstraints();
		gbc_sequencePanelButtomTitre.anchor = GridBagConstraints.NORTHWEST;
		gbc_sequencePanelButtomTitre.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelButtomTitre.gridx = 0;
		gbc_sequencePanelButtomTitre.gridy = 0;
		sequencePanelButtom.add(sequencePanelButtomTitre, gbc_sequencePanelButtomTitre);
		sequencePanelButtomTitre.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel label_12 = new JLabel("Compétences");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelButtomTitre.add(label_12);

		JLabel label_13 = new JLabel("Indicateur de performance");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelButtomTitre.add(label_13);

		JLabel label_14 = new JLabel("Savoirs associés");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		sequencePanelButtomTitre.add(label_14);

		JPanel sequencePanelButtomButton = new JPanel();
		GridBagConstraints gbc_sequencePanelButtomButton = new GridBagConstraints();
		gbc_sequencePanelButtomButton.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelButtomButton.insets = new Insets(0, 0, 5, 0);
		gbc_sequencePanelButtomButton.gridx = 0;
		gbc_sequencePanelButtomButton.gridy = 1;
		sequencePanelButtom.add(sequencePanelButtomButton, gbc_sequencePanelButtomButton);
		sequencePanelButtomButton.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_1 = new JButton("Ajouter une compétence");
		sequencePanelButtomButton.add(btnNewButton_1, BorderLayout.WEST);

		JPanel sequencePanelButtomComp = new JPanel();
		GridBagConstraints gbc_sequencePanelButtomComp = new GridBagConstraints();
		gbc_sequencePanelButtomComp.fill = GridBagConstraints.BOTH;
		gbc_sequencePanelButtomComp.gridx = 0;
		gbc_sequencePanelButtomComp.gridy = 2;
		sequencePanelButtom.add(sequencePanelButtomComp, gbc_sequencePanelButtomComp);
		sequencePanelButtomComp.setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel_20 = new JPanel();
		sequencePanelButtomComp.add(panel_20);

		JLabel label_15 = new JLabel("New label");
		panel_20.add(label_15);

		JPanel panel_21 = new JPanel();
		sequencePanelButtomComp.add(panel_21);

		JLabel label_16 = new JLabel("New label");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(label_16);

		JPanel panel_22 = new JPanel();
		sequencePanelButtomComp.add(panel_22);

		JLabel label_17 = new JLabel("New label");
		panel_22.add(label_17);

	}

	@Override
	public Dimension getPreferredScrollableViewportSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getScrollableBlockIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getScrollableTracksViewportHeight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getScrollableTracksViewportWidth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScrollableUnitIncrement(Rectangle arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
