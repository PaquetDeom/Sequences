package fr.paquet.ihm.gestionnaire.savoir;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import fr.paquet.ihm.commun.gestionnaire.JDialogGestion;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Savoir;
import fr.paquet.referentiel.SavoirAssocie;

public class JDialogSavoir extends JDialogGestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JDialogSavoir(CompetenceIntermediaire competenceIntermediaire) {
		super("Gestionnaire des savoirs", competenceIntermediaire);
//TODO
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

	}

	private CompetenceIntermediaire getCompetenceIntermediaire() {
		return (CompetenceIntermediaire) getObject();
	}

	private List<Savoir> getSavoirs() {

		List<Savoir> savoirs = getCompetenceIntermediaire().getCompetence().getSavoirs();

		return savoirs;
	}

	private List<SavoirAssocie> savAssSelect = null;

	public List<SavoirAssocie> getSavAssSelect() {
		if (savAssSelect == null)
			savAssSelect = new ArrayList<SavoirAssocie>();
		return savAssSelect;

	}

	@Override
	protected void setJtreeGestionnaire() {
		JTreeGestionnaireSavoir jtreeGestionnaire = new JTreeGestionnaireSavoir(getSavoirs());
		this.jtreeGestionnaire = jtreeGestionnaire;

	}

	@Override
	protected void setJPanelGestionnaireRight() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void setButtomPanel() {
		// TODO Auto-generated method stub

	}

}
