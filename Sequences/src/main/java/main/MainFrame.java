package main;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import fr.paquet.sequence.Sequence;
import fr.paquet.sequence.SequenceVersion;

public class MainFrame extends JFrame implements WindowListener {

	/*
	 * @author Nathanael
	 * 
	 * Fenetre pricipale du logiciel<br/>
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame = null;
	private JPanel panelOuverture = null;
	private MainOnglet mainOnglet = null;

	private MainFrame() {

		super("Logiciel d'écriture pédagogique");

		setPanelOuverture();
		addWindowListener(this);
		setAlwaysOnTop(false);
		setMinimumSize(new Dimension(900, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(MainMenu.getUniqInstance());
		add(getPanelOuverture());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	private void setPanelOuverture() {
		JPanel p = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("./target/classes/images/presentation.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(img.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH), 0, 0, null);
			}

		};
		p.setLayout(new FlowLayout());
		this.panelOuverture = p;
	}

	public JPanel getPanelOuverture() {
		return panelOuverture;
	}

	/**
	 * 
	 * @return l'instance unique de la class<br/>
	 * @throws Exception
	 * @throws s
	 */
	public static MainFrame getUniqInstance() {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		mainFrame.repaint();

		return mainFrame;
	}

	/**
	 * 
	 * @param panel supprime le panel de la fenêtre
	 * @throws Exception
	 */
	private void removePanel(JPanel panel) throws Exception {
		MainFrame.getUniqInstance().remove(panel);
	}

	/**
	 * Remplace le panel de la fenêtre
	 * 
	 * @param panelRemove
	 * @param panelAdd
	 * @throws Exception
	 */
	public void addPanel(SequenceVersion sequenceVersion) throws Exception {
		removePanel(getPanelOuverture());
		setMainOnglet(new MainOnglet(sequenceVersion));
		add(getMainOnglet());
		revalidate();
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	public void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Main.Fermeture();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
