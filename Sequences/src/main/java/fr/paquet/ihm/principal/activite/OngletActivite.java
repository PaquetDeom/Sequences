package fr.paquet.ihm.principal.activite;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import main.MainOnglet;

public class OngletActivite extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MainOnglet mainOnglet = null;

	public OngletActivite(MainOnglet mainOnglet) throws Exception {

		super();

		// setteur des components
		setMainOnglet(mainOnglet);

		// rempli la liste des onglets dans MainOnglet
		JScrollPane js = new JScrollPane(getActivitePanel());
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// TODO revoir la position du titre
		getMainOnglet().addOngletsActivites(this);
		getMainOnglet().addTab(getActivitePanel().getTitre(), js);
	}

	private ActivitePanel activitePanel = null;

	public ActivitePanel getActivitePanel() {
		if (activitePanel == null)
			activitePanel = new ActivitePanel(this);
		return activitePanel;
	}

	public MainOnglet getMainOnglet() {
		return mainOnglet;
	}

	private void setMainOnglet(MainOnglet mainOnglet) {
		this.mainOnglet = mainOnglet;
	}

}
