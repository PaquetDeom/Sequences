package fr.paquet.ihm.principal.activite;

import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class JSplitPaneActProFEleve extends JSplitPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanelStrategie activitePanelStrategie = null;

	public JSplitPaneActProFEleve(ActivitePanelStrategie activitePanelStrategie) {
		super();

		// set des composants
		setActivitePanelStrategie(activitePanelStrategie);

		// attributs du splitpane
		this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);

		// ajout des composants au plitpane
		setLeftComponent(new JLabel("essai1"));
		setRightComponent(new JLabel("essai2"));
		
	}

	private JSrollPaneProf jSrollPaneProf = null;

	public JSrollPaneProf getJScrollPaneProf() {
		if (jSrollPaneProf == null)
			jSrollPaneProf = new JSrollPaneProf(this);
		return jSrollPaneProf;
	}

	private JSrollPaneEleve jSrollPaneEleve = null;

	public JSrollPaneEleve getJScrollPaneEleve() {
		if (jSrollPaneEleve == null)
			jSrollPaneEleve = new JSrollPaneEleve(this);
		return jSrollPaneEleve;
	}

	public ActivitePanelStrategie getActivitePanelStrategie() {
		return activitePanelStrategie;
	}

	private void setActivitePanelStrategie(ActivitePanelStrategie activitePanelStrategie) {
		this.activitePanelStrategie = activitePanelStrategie;
	}

}
