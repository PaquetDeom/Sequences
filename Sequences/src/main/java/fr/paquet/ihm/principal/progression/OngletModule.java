package fr.paquet.ihm.principal.progression;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;

import fr.paquet.module.ModuleVersion;
import fr.paquet.progression.ProgressionVersion;
import main.MainOnglet;

public class OngletModule extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Cree un nouvel onglet<br/>
	 * 
	 * @throws BadLocationException
	 * 
	 * @throws Exception
	 */
	public OngletModule(ModuleVersion moduleVersion) throws BadLocationException {

		super();

		// Layout
		setLayout(new BorderLayout());
		// Scroll
		JScrollPane js = new JScrollPane(getProgressionPanel());
		add(js, BorderLayout.CENTER);
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		MainOnglet.getUniqInstance().setOngletModule(this);

		// attribut de l'onglet

	}

	private ProgressionPanel progressionPanel = null;

	public ProgressionPanel getProgressionPanel() throws BadLocationException {
		if (progressionPanel == null)
			progressionPanel = new ProgressionPanel(this);
		return progressionPanel;
	}

}
