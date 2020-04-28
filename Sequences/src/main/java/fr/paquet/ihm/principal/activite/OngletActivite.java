package fr.paquet.ihm.principal.activite;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import fr.paquet.activite.Activite_1;
import main.MainOnglet;

public class OngletActivite extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Activite_1 activite = null;

	public OngletActivite(Activite_1 activite) throws Exception {

		super();

		// setteur des components
		setActivite(activite);

		// rempli la liste des onglets dans MainOnglet
		JScrollPane js = new JScrollPane(getActivitePanel());
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// TODO revoir la position du titre
		MainOnglet.getUniqInstance().addOngletsActivites(this);
		MainOnglet.getUniqInstance().addTab(getActivitePanel().getTitre(), js);
	}

	private ActivitePanel activitePanel = null;

	public ActivitePanel getActivitePanel() {
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
