package fr.paquet.ihm.principal.activite;

import javax.swing.JSplitPane;

import fr.paquet.ihm.style.StyleBorder;

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
		setOrientation(JSplitPane.HORIZONTAL_SPLIT);

		// ajout des composants au plitpane
		setLeftComponent(getJPanelActiviteProf());
		setRightComponent(getJPanelActiviteEleve());

		setResizeWeight(0.5);
		setContinuousLayout(true);

	}

	private JPanelActiviteProf jPanelActiviteProf = null;

	public JPanelActiviteProf getJPanelActiviteProf() {
		if (jPanelActiviteProf == null) {
			jPanelActiviteProf = new JPanelActiviteProf(this);
			jPanelActiviteProf.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
		}
		return jPanelActiviteProf;
	}

	private JPanelActiviteEleve jPanelActiviteEleve = null;

	public JPanelActiviteEleve getJPanelActiviteEleve() {
		if (jPanelActiviteEleve == null) {
			jPanelActiviteEleve = new JPanelActiviteEleve(this);
			jPanelActiviteEleve.setBorder(StyleBorder.BORDERTITLEAREA.getBorder());
		}
		return jPanelActiviteEleve;
	}

	public ActivitePanelStrategie getActivitePanelStrategie() {
		return activitePanelStrategie;
	}

	private void setActivitePanelStrategie(ActivitePanelStrategie activitePanelStrategie) {
		this.activitePanelStrategie = activitePanelStrategie;
	}

	

}
