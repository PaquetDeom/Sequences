package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ActivitePanelConception extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelConception(ActivitePanel activitePanel) {
		super();

		// set des composants
		setActivitepanel(activitePanel);

		// ajout du Layout
		setLayout(new GridBagLayout());

		// attribut du panel

		// ajout des Composants
		add(getMainSplitPane(), new GridBagConstraints(0, 0, 1, 1, 1, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

	}

	private JSplitPane getMainSplitPane() {
		JSplitPane mainSplitPane = new JSplitPane();

		mainSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setLeftComponent(getActivitePanelConceptionQuestion());
		mainSplitPane.setRightComponent(getRightMainSplitPane());

		mainSplitPane.setResizeWeight(0.25);
		mainSplitPane.setContinuousLayout(true);

		return mainSplitPane;
	}

	private JSplitPane getRightMainSplitPane() {
		JSplitPane mainRightSplitPane = new JSplitPane();

		mainRightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainRightSplitPane.setTopComponent(getActivitePanelConceptionDocuments());
		mainRightSplitPane.setBottomComponent(getSecondRightSplitPane());

		mainRightSplitPane.setResizeWeight(0.33);
		mainRightSplitPane.setContinuousLayout(true);

		return mainRightSplitPane;
	}

	private JSplitPane getSecondRightSplitPane() {
		JSplitPane secondRightSplitPane = new JSplitPane();

		secondRightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		secondRightSplitPane.setTopComponent(getActivitePanelConceptionRessources());
		secondRightSplitPane.setBottomComponent(getActivitePanelConceptionTrace());

		secondRightSplitPane.setResizeWeight(0.5);
		secondRightSplitPane.setContinuousLayout(true);

		return secondRightSplitPane;
	}

	private ActivitePanelConceptionTrace activitePanelConceptionTrace = null;

	private ActivitePanelConceptionTrace getActivitePanelConceptionTrace() {
		if (activitePanelConceptionTrace == null)
			activitePanelConceptionTrace = new ActivitePanelConceptionTrace(this);
		return activitePanelConceptionTrace;
	}

	private ActivitePanelConceptionRessources activitePanelConceptionRessources = null;

	private ActivitePanelConceptionRessources getActivitePanelConceptionRessources() {
		if (activitePanelConceptionRessources == null)
			activitePanelConceptionRessources = new ActivitePanelConceptionRessources(this);
		return activitePanelConceptionRessources;
	}

	private ActivitePanelConceptionDocuments activitePanelConceptionDocuments = null;

	private ActivitePanelConceptionDocuments getActivitePanelConceptionDocuments() {
		if (activitePanelConceptionDocuments == null)
			activitePanelConceptionDocuments = new ActivitePanelConceptionDocuments(this);
		return activitePanelConceptionDocuments;
	}

	private ActivitePanelConceptionQuestion activitePanelConceptionQuestion = null;

	private ActivitePanelConceptionQuestion getActivitePanelConceptionQuestion() {
		if (activitePanelConceptionQuestion == null)
			activitePanelConceptionQuestion = new ActivitePanelConceptionQuestion(this);
		return activitePanelConceptionQuestion;
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;
	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
	}

}
