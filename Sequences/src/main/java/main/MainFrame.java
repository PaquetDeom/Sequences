package main;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import fr.paquet.ihm.ToolBar.SequenceToolBar;
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

		setMainOnglet(MainOnglet.getUniqInstance());
		setPanelOuverture();
		addWindowListener(this);
		setAlwaysOnTop(false);
		setMinimumSize(new Dimension(900, 600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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

	private JPanel getPanelOuverture() {
		return panelOuverture;
	}

	public void affichePanelOuverture() throws Exception {
		removePanel(getMainOnglet());
		add(getPanelOuverture());
		revalidate();
	}

	/**
	 * 
	 * @return l'instance unique de la class<br/>
	 * @throws Exception
	 * @throws s
	 */
	public static MainFrame getUniqInstance() {
		if (mainFrame == null) {
			mainFrame = new MainFrame();
			mainFrame.setJMenuBar(MainMenu.getUniqInstance());
		}
		mainFrame.repaint();

		return mainFrame;
	}

	/**
	 * 
	 * @param panel supprime le panel de la fenêtre
	 * @throws Exception
	 */
	private void removePanel(Component component) throws Exception {
		MainFrame.getUniqInstance().remove(component);
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
		setSequenceVersion(sequenceVersion);
		getMainOnglet().init(getSequenceVersion());
		add(SequenceToolBar.getUniqintance(), BorderLayout.NORTH);
		add(getMainOnglet());
		revalidate();
	}

	private SequenceVersion sequenceVersion = null;

	public SequenceVersion getSequenceVersion() {
		return this.sequenceVersion;
	}

	public void setSequenceVersion(SequenceVersion sequenceVersion) {
		SequenceVersion oldValue = this.sequenceVersion;
		this.sequenceVersion = sequenceVersion;
		this.pcs.firePropertyChange("sequenceVersion", oldValue, sequenceVersion);
	}

	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.pcs.removePropertyChangeListener(listener);
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	public void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Main.Fermeture();

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

	public void initPanelOuverture() throws Exception {
		affichePanelOuverture();
		setSequenceVersion(null);

	}

}
