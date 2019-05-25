package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

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

	private MainFrame() throws Exception {
		super("Logiciel d'écriture pédagogique");
		addWindowListener(this);
		setAlwaysOnTop(false);
		setMinimumSize(new Dimension(900, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setJMenuBar(MainMenu.getUniqInstance());
		add(getmasterPanel());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	private Component getmasterPanel() {
		JPanel p = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("./target/classes/images/classe.jpeg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(img.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH), 0, 0, null);
			}

		};
		p.setLayout(new BorderLayout());
		return p;
	}

	/**
	 * 
	 * @return l'instance unique de la class<br/>
	 * @throws Exception
	 * @throws s
	 */
	public static MainFrame getUniqInstance() throws Exception {
		if (mainFrame == null)
			mainFrame = new MainFrame();
		return mainFrame;
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
		// TODO

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
