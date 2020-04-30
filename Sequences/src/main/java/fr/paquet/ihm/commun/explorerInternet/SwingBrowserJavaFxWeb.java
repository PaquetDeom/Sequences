package fr.paquet.ihm.commun.explorerInternet;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import main.MainFrame;

public class SwingBrowserJavaFxWeb extends JDialog implements WindowListener, PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final JFXPanel jfxPanel = new JFXPanel();
	private static WebEngine engine = null;

	private final JPanel panel = new JPanel(new BorderLayout());
	private final JLabel lblStatus = new JLabel();

	private final JProgressBar progressBar = new JProgressBar();
	private static String url = null;

	public SwingBrowserJavaFxWeb(String url) {
		super(MainFrame.getUniqInstance());

		SwingBrowserJavaFxWeb.url = url;
		initComponents();
	}

	private Task task = null;
	private boolean done = true;

	public void done() {
		// Tell progress listener to stop updating progress bar.
		done = true;
		Toolkit.getDefaultToolkit().beep();

		setCursor(null); // turn off the wait cursor
		progressBar.setValue(progressBar.getMinimum());

	}

	private void initComponents() {

		progressBar.setPreferredSize(new Dimension(150, 18));
		progressBar.setStringPainted(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		done = false;
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();

		initFx();

		JPanel statusBar = new JPanel(new BorderLayout(5, 0));
		statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
		statusBar.add(lblStatus, BorderLayout.CENTER);
		statusBar.add(progressBar, BorderLayout.EAST);

		panel.add(jfxPanel, BorderLayout.CENTER);
		panel.add(statusBar, BorderLayout.SOUTH);

		getContentPane().add(panel);
		wight = 1880;
		height = 980;
		setPreferredSize(new Dimension(wight, height));
		setResizable(false);

		pack();
		setVisible(true);

	}

	private static void initFx() {
		Platform.runLater(new ThreadFx());
	}

	private static ThreadFx threadFx = null;

	public static class ThreadFx extends Thread {

		@Override
		public void run() {
			super.run();

			createSceneFx(url);
			jfxPanel.setScene(scene);
		}
	}

	private static int wight = 0;
	private static int height = 0;
	private static Scene scene = null;

	private static Scene createSceneFx(String url) {

		Group root = new Group();
		scene = new Scene(root, Color.ALICEBLUE);

		WebView web = new WebView();
		web.setPrefSize(wight, height);
		engine = web.getEngine();

		String tmp = toURL(url);

		if (url == null) {
			tmp = toURL(url);
		}

		engine.load(tmp);

		root.getChildren().add(web);

		return scene;

	}

	private static String toURL(String str) {
		try {
			return new URL(str).toExternalForm();
		} catch (MalformedURLException exception) {
			return null;
		}
	}

	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		threadFx.interrupt();
		this.dispose();

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

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		if (!done) {
			int progress = task.getProgress();
			if (progress == 0) {
				progressBar.setIndeterminate(true);

			} else {
				progressBar.setIndeterminate(false);
				progressBar.setString(null);
				progressBar.setValue(progress);
			}
		}
	}

}
