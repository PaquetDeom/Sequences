package fr.paquet.ihm.activite.ressource;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;

public class MainPanelActiviteRessource extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogRessource jDialogRessource = null;

	public MainPanelActiviteRessource(JDialogRessource jDialogRessource) {
		super();

		// set des components
		setjDialogRessource(jDialogRessource);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// ajout des composants
		affiche();

		// attributs du panel
		setBorder(StyleBorder.BORDERPANEL.getBorder());
	}

	private void affiche() {
		removeAll();

		add(getPanelText(), new GridBagConstraints(0, 0, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
		add(getPanelUrl(), new GridBagConstraints(0, 1, 1, 1, 1, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 1, 0));
		add(getPanelButton(), new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 1, 0));

		revalidate();
	}

	private JPanelButtonActiviteRessource jPanelButtonActiviteRessource = null;

	public JPanelButtonActiviteRessource getPanelButton() {
		if (jPanelButtonActiviteRessource == null)
			jPanelButtonActiviteRessource = new JPanelButtonActiviteRessource(this);
		return jPanelButtonActiviteRessource;
	}

	private JPanelTextActiviteRessource jPanelTextActiviteRessource = null;

	public JPanelTextActiviteRessource getPanelText() {
		if (jPanelTextActiviteRessource == null)
			jPanelTextActiviteRessource = new JPanelTextActiviteRessource(this);
		return jPanelTextActiviteRessource;
	}

	private JPanelUrlActiviteRessource jPanelUrlActiviteRessource = null;

	public JPanelUrlActiviteRessource getPanelUrl() {
		if (jPanelUrlActiviteRessource == null)
			jPanelUrlActiviteRessource = new JPanelUrlActiviteRessource(this);
		return jPanelUrlActiviteRessource;
	}

	public JDialogRessource getjDialogRessource() {
		return jDialogRessource;
	}

	public void setjDialogRessource(JDialogRessource jDialogRessource) {
		this.jDialogRessource = jDialogRessource;
	}

}
