package fr.paquet.ihm.principal.activite;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.BadLocationException;

import fr.paquet.activite.Activite_1;
import main.MainOnglet;

public class OngletActivite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Activite_1 activite = null;

	public OngletActivite(Activite_1 activite) throws BadLocationException {

		super();

		// layout
		setLayout(new BorderLayout());

		// setteur des components
		setActivite(activite);

		// rempli la liste des onglets dans MainOnglet
		JScrollPane jS = new JScrollPane(getActivitePanel());
		add(jS, BorderLayout.CENTER);
		jS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jS.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		MainOnglet.getUniqInstance().addOngletsActivites(this);

	}

	private ActivitePanel activitePanel = null;

	public ActivitePanel getActivitePanel() throws BadLocationException {
		if (activitePanel == null)
			activitePanel = new ActivitePanel(this);
		return activitePanel;
	}

	public Activite_1 getActivite() {
		return activite;
	}

	private void setActivite(Activite_1 activite) {
		this.activite = activite;
	}


}
