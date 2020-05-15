package fr.paquet.ihm.gestionnaire.activite;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.ihm.principal.activite.OngletActivite;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;
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

		try {
			if (button.getText().equals("Fermer")) {
				getSequenceVersion().setActivites(getActivites());
				MainOnglet.getUniqInstance().removeAllOngletActivites();
				for (Activite_1 act : getSequenceVersion().getActivites()) {
					OngletActivite Oa = new OngletActivite(act);

					MainOnglet.getUniqInstance().addOngletsActivites(Oa);
					MainOnglet.getUniqInstance().setSelectedIndex(0);
				}
				MainOnglet.getUniqInstance().affiche();
				this.dispose();
			}

		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}

		if (button.getText().equals("Ajouter une activite")) {
			try {

				if (MainFrame.getUniqInstance().getSequenceVersion()
						.isModifiable(Connect.getPConnexion().getUser().getAuteur())) {

					new Activite_1(MainFrame.getUniqInstance().getSequenceVersion());

					MainOnglet.getUniqInstance().affiche();
					MainOnglet.getUniqInstance().setSelectedIndex(MainOnglet.getUniqInstance().getTabCount() - 1);

					this.dispose();
				} else
					new AlertWindow(AlertType.ATTENTION, "La séquence n'est pas modifiable");
			} catch (Exception e) {
				new AlertWindow(AlertType.ERREUR, "L'activité n'a pas été crée");
				e.printStackTrace();
			}
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
			activites = (List<Activite_1>) ((List<Activite_1>) getSequenceVersion().getActivites());
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
		try {
			if (button.equals("Oui")) {

				// supprime l'activité
				Activite_1 activite = (Activite_1) getJPanelGestionnaireRight().getObjectSelected();
				MainFrame.getUniqInstance().getSequenceVersion().removePropertyChangeListener(activite);
				getActivites().remove(activite);

				// supprimer le noeud du Jtree
				((DefaultTreeModel) getJtreGestionnaire().getJTreeValue().getModel())
						.removeNodeFromParent((MutableTreeNode) getJtreGestionnaire().getJTreeValue().getSelectionPath()
								.getLastPathComponent());

				getSequenceVersion().setActivites(getActivites());
				MainOnglet.getUniqInstance().removeAllOngletActivites();
				for (Activite_1 act : getSequenceVersion().getActivites()) {
					MainOnglet.getUniqInstance().addOngletsActivites(new OngletActivite(act));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			new AlertWindow(AlertType.ERREUR, e.getMessage());
		}

	}

	@Override
	protected void addButton() {

		JButton buttonOui = new JButton("Fermer");
		buttonOui.addActionListener(this);

		JButton buttonAdd = new JButton("Ajouter une activite");
		buttonAdd.addActionListener(this);

		getButtons().add(buttonAdd);
		getButtons().add(buttonOui);

	}

}
