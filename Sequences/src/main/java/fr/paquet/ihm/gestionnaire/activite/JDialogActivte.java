package fr.paquet.ihm.gestionnaire.activite;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import fr.paquet.activite.Activite_1;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.principal.activite.OngletActivite;
import fr.paquet.sequence.SequenceVersion;
import main.MainOnglet;

public class JDialogActivte extends JDialogGestion implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogActivte(SequenceVersion sequenceVersion) {
		super("Gestionnaire des activtés", sequenceVersion);

		affiche();
	}

	private SequenceVersion getSequenceVersion() {
		return (SequenceVersion) getObject();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton button = (JButton) event.getSource();

		if (button.getText().equals("Supprimer")) {
			new AlertWindow(AlertType.QUESTION, "L'activité va être definitivement supprimée", this);

		}

		if (button.getText().equals("Fermer")) {
			getSequenceVersion().setActivites(getActivites());
			MainOnglet.getUniqInstance().removeAllOngletActivites();
			for (Activite_1 act : getSequenceVersion().getActivites()) {
				MainOnglet.getUniqInstance().addOngletsActivites(new OngletActivite(act));
			}
			MainOnglet.getUniqInstance().affiche();
			this.dispose();
		}

	}

	@Override
	protected void setJtreeGestionnaire() {
		JTreeGestionnaireActivite jTreeGestionnaireActivite = new JTreeGestionnaireActivite(getActivites());
		this.jtreeGestionnaire = jTreeGestionnaireActivite;

	}

	private List<Activite_1> activites = null;

	private List<Activite_1> getActivites() {
		if (activites == null)
			activites = (ArrayList<Activite_1>) ((ArrayList<Activite_1>) getSequenceVersion().getActivites());
		return activites;
	}

	@Override
	protected void setJPanelGestionnaireRight() {
		JPanelGestionnaireActiviteRight panel = new JPanelGestionnaireActiviteRight(this);
		this.jPanelGestionnaireRight = panel;

	}

	@Override
	protected void setButtomPanel() {

	}

	@Override
	public void buttonClick(String button) {

		if (button.equals("Oui")) {

			Activite_1 activite = (Activite_1) getJPanelGestionnaireRight().getObjectSelected();
			getActivites().remove(activite);

			// supprimer le noeud du Jtree
			((DefaultTreeModel) getJtreGestionnaire().getJTreeValue().getModel()).removeNodeFromParent(
					(MutableTreeNode) getJtreGestionnaire().getJTreeValue().getSelectionPath().getLastPathComponent());

			getSequenceVersion().setActivites(getActivites());
			MainOnglet.getUniqInstance().removeAllOngletActivites();
			for (Activite_1 act : getSequenceVersion().getActivites()) {
				MainOnglet.getUniqInstance().addOngletsActivites(new OngletActivite(act));
			}

		}

	}

	@Override
	protected void addButton() {

		JButton buttonOui = new JButton("Fermer");
		buttonOui.addActionListener(this);


		getButtons().add(buttonOui);
		

	}

}
