package fr.paquet.ihm.ouvrir;

import java.awt.GridBagLayout;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.FileChooserUI;

import fr.paquet.dataBase.Factory.sequence.SequenceFactory;
import fr.paquet.ihm.alert.AlertListener;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.sequence.Sequence;

public class Gestionnaire extends JDialog implements AlertListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableSequences = null;
	private List<Sequence> sequences = null;
	private Sequence sequenceSelected = null;
	private JButton buttonOuvrir = null;
	private JButton buttonDelete = null;
	private GestionnaireModel model = null;

	/**
	 * 
	 * @return la liste des sequences</br>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<Sequence> getSequences() throws Exception {
		sequences = (List<Sequence>) new SequenceFactory().findAll();
		return sequences;
	}

	/**
	 * 
	 * @return le model de JTable</br>
	 */
	private GestionnaireModel getGModel() {
		return model;
	}

	/**
	 * mutte la variable model de type GestionnaireModel<br/>
	 * 
	 * @param model
	 */
	private void setGModel(GestionnaireModel model) {
		this.model = model;
	}

	/**
	 * mutte la variable tableProjets de type Jtable<br/>
	 * 
	 * @param table
	 * @throws Exception
	 */
	private void setTableProjets(JTable table) throws Exception {

		// ajout du model à la Jtable
		table.setModel(getGModel());

		// donne le type de sélection dans la JTable
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListSelectionModel rowSM = table.getSelectionModel();

		// ajout d'un listener
		rowSM.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				DefaultListSelectionModel dLSM = (DefaultListSelectionModel) e.getSource();
				int i = dLSM.getMinSelectionIndex();

				try {

					setSequenceSelected(getSequences().get(i));

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		this.tableSequences = table;
	}

	private void setSequenceSelected(Sequence sequence) {
		this.sequenceSelected = sequence;
	}

	private Sequence getSequenceSelected() {
		return sequenceSelected;
	}

	private JTable getTableSequences() throws Exception {

		return tableSequences;
	}

	public Gestionnaire() {

		super();

		try {
			// creation du model de JTable
			setGModel(new GestionnaireModel(getSequences()));

			// creation de la fenêtre
			setTitle("Gestionnaire de sequences");
			setSize(900, 600);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setAlwaysOnTop(false);
			setVisible(true);

			// creation du layout
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
					0.0, Double.MIN_VALUE };
			gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
					Double.MIN_VALUE };

			// ajout du layout au panel
			getContentPane().setLayout(gridBagLayout);

			// creation du constraint
			GridBagConstraints gbc_table = new GridBagConstraints();
			gbc_table.gridheight = 8;
			gbc_table.gridwidth = 12;
			gbc_table.insets = new Insets(5, 5, 5, 5);
			gbc_table.fill = GridBagConstraints.BOTH;
			gbc_table.gridx = 0;
			gbc_table.gridy = 1;

			// ajout du button ouvrir
			GridBagConstraints gbc_btnOuvrir = new GridBagConstraints();
			gbc_btnOuvrir.insets = new Insets(10, 0, 5, 0);
			gbc_btnOuvrir.gridx = 12;
			gbc_btnOuvrir.gridy = 5;
			getContentPane().add(getButtonOuvrir(), gbc_btnOuvrir);

			// ajout du button delete
			GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
			gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
			gbc_btnSupprimer.gridx = 12;
			gbc_btnSupprimer.gridy = 6;
			getContentPane().add(getButtonDelete(), gbc_btnSupprimer);

			// creation de la table
			setTableProjets(new JTable());

			// ajout de la JTable au Jpanel
			getContentPane().add(getTableSequences(), gbc_table);

		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, e.getMessage());
			e.printStackTrace(System.out);
		}

	}

	private JButton getButtonDelete() {
		if (buttonDelete == null)
			buttonDelete = new JButton("Supprimer");

		buttonDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (getSequenceSelected() != null) {

					new AlertWindow(AlertType.QUESTION, "Etes vous sûre de vouloir supprimer le projet",
							Gestionnaire.this);

				}

			}
		});

		return buttonDelete;
	}

	private JButton getButtonOuvrir() {
		if (buttonOuvrir == null)
			buttonOuvrir = new JButton("Ouvrir");

		buttonOuvrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				/**
				 * OngletProjet c = new OngletProjet(getProjetSelected());
				 * MainMenu.getUniqInstance().getActionSave().setProjet(getProjetSelected());
				 * MainMenu.getUniqInstance().getAction3D().setProjet(getProjetSelected());
				 * MainMenu.getUniqInstance().getActionUrl().setProjet(getProjetSelected());
				 * Gestionnaire.this.dispose(); c.setVisible(true);
				 */
			}
		});

		return buttonOuvrir;
	}

	@Override
	public void buttonClick(String button) {
		if (button.equals("Oui")) {
			try {
				new SequenceFactory().remove(getSequenceSelected());
			} catch (Exception e) {
				e.printStackTrace();
				new AlertWindow(AlertType.ERREUR, e.getMessage());
			}
			Gestionnaire.this.dispose();
		}

	}

}
