package fr.paquet.ihm.principal.activite;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.text.BadLocationException;

public class ActivitePanelConception extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ActivitePanel activitepanel = null;

	public ActivitePanelConception(ActivitePanel activitePanel) throws BadLocationException {
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

	private JSplitPane getMainSplitPane() throws BadLocationException {
		JSplitPane mainSplitPane = new JSplitPane();

		mainSplitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		mainSplitPane.setLeftComponent(getActivitePanelConceptionQuestion());
		mainSplitPane.setRightComponent(getRightMainSplitPane());

		mainSplitPane.setResizeWeight(0.5);
		mainSplitPane.setContinuousLayout(true);

		return mainSplitPane;
	}

	private JSplitPane getRightMainSplitPane() throws BadLocationException {
		JSplitPane mainRightSplitPane = new JSplitPane();

		mainRightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mainRightSplitPane.setTopComponent(getActivitePanelConceptionDocuments());
		mainRightSplitPane.setBottomComponent(getSecondRightSplitPane());

		mainRightSplitPane.setResizeWeight(0.33);
		mainRightSplitPane.setContinuousLayout(true);

		return mainRightSplitPane;
	}

	private JSplitPane getSecondRightSplitPane() throws BadLocationException {
		JSplitPane secondRightSplitPane = new JSplitPane();

		secondRightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		secondRightSplitPane.setTopComponent(getActivitePanelConceptionRessources());
		secondRightSplitPane.setBottomComponent(getActivitePanelConceptionTrace());

		secondRightSplitPane.setResizeWeight(0.5);
		secondRightSplitPane.setContinuousLayout(true);

		return secondRightSplitPane;
	}

	private ActivitePanelConceptionTrace activitePanelConceptionTrace = null;

	private ActivitePanelConceptionTrace getActivitePanelConceptionTrace() throws BadLocationException {
		if (activitePanelConceptionTrace == null)
			activitePanelConceptionTrace = new ActivitePanelConceptionTrace(this);
		return activitePanelConceptionTrace;
	}

	private ActivitePanelConceptionRessources activitePanelConceptionRessources = null;

	private ActivitePanelConceptionRessources getActivitePanelConceptionRessources() throws BadLocationException {
		if (activitePanelConceptionRessources == null)
			activitePanelConceptionRessources = new ActivitePanelConceptionRessources(this);
		return activitePanelConceptionRessources;
	}

	private ActivitePanelConceptionDocuments activitePanelConceptionDocuments = null;

	private ActivitePanelConceptionDocuments getActivitePanelConceptionDocuments() throws BadLocationException {
		if (activitePanelConceptionDocuments == null)
			activitePanelConceptionDocuments = new ActivitePanelConceptionDocuments(this);
		return activitePanelConceptionDocuments;
	}

	private ActivitePanelConceptionQuestion activitePanelConceptionQuestion = null;

	private ActivitePanelConceptionQuestion getActivitePanelConceptionQuestion() throws BadLocationException {
		if (activitePanelConceptionQuestion == null) {
			if (getActivitepanel().getOngletActivite().getActivite().getQuestionnement() == null)
				activitePanelConceptionQuestion = new ActivitePanelConceptionQuestion(this);
			else
				activitePanelConceptionQuestion = new ActivitePanelConceptionQuestion(
						getActivitepanel().getOngletActivite().getActivite().getQuestionnement(), this);
		}
		return activitePanelConceptionQuestion;
	}

	public ActivitePanel getActivitepanel() {
		return activitepanel;
	}

	private void setActivitepanel(ActivitePanel activitepanel) {
		this.activitepanel = activitepanel;
	}

}
