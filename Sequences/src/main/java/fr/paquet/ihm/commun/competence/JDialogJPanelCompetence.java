package fr.paquet.ihm.commun.competence;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JPanel;

import fr.paquet.ihm.style.StyleBorder;
import fr.paquet.referentiel.Competence;
import fr.paquet.referentiel.CompetenceIntermediaire;

import java.awt.GridBagConstraints;

public class JDialogJPanelCompetence extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDialogJPanelRef jDialogJPanelRef = null;
	private List<JDialogJtreeComp> jDialogJtreeComps = null;
	private Hashtable<Competence, List<CompetenceIntermediaire>> valuesJTree = null;

	public JDialogJPanelCompetence(JDialogJPanelRef jDialogJPanelRef) {
		super();

		// setteur des component
		setjDialogJPanelRef(jDialogJPanelRef);
		initJTree(getjDialogJPanelRef().getjDialogJPanel().getjDialogCompetence().getCompetenceIntermediaires());

		// ajout du layout
		setLayout(new GridBagLayout());

		// attribut du panel
		setBorder(StyleBorder.BORDERPANELCOMP.getBorder());

		// affichage des elements
		for (int i = 0; i < getjDialogJtreeComps().size(); i++) {
			add(getjDialogJPanelRef(), new GridBagConstraints(i, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}

	}

	private void initJTree(List<CompetenceIntermediaire> compInts) {

		for (CompetenceIntermediaire compint : compInts) {
			Competence comp = compint.getCompetence();

			if (!getValuesJTree().containsKey(comp)) {
				List<CompetenceIntermediaire> compintss = new ArrayList<CompetenceIntermediaire>();
				compintss.add(compint);
				getValuesJTree().put(comp, compintss);
			} else {
				List<CompetenceIntermediaire> compintss = getValuesJTree().get(comp);
				compintss.add(compint);
			}

		}
	}

	private Hashtable<Competence, List<CompetenceIntermediaire>> getValuesJTree() {
		if (valuesJTree == null)
			valuesJTree = new Hashtable<Competence, List<CompetenceIntermediaire>>();
		return valuesJTree;
	}

	private JDialogJPanelRef getjDialogJPanelRef() {
		return jDialogJPanelRef;
	}

	private void setjDialogJPanelRef(JDialogJPanelRef jDialogJPanelRef) {
		this.jDialogJPanelRef = jDialogJPanelRef;
	}

	private List<JDialogJtreeComp> getjDialogJtreeComps() {
		if (jDialogJtreeComps == null) {
			jDialogJtreeComps = new ArrayList<JDialogJtreeComp>();

			for (int i = 0; i < getValuesJTree().size(); i++) {

				new JDialogJtreeComp(getValuesJTree().get(i));
				
			}

		}

		return jDialogJtreeComps;
	}

	public void addjDialogJtreeComps(JDialogJtreeComp jDialogJtreeComps) {
		getjDialogJtreeComps().add(jDialogJtreeComps);
	}

}
