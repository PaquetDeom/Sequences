package fr.paquet.ihm.commun;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JPanel;

import javax.swing.text.BadLocationException;

import fr.paquet.referentiel.CompetenceIntermediaire;

import fr.paquet.referentiel.SavoirAssocie;

public abstract class JTableCompetences extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<CompetenceIntermediaire> competenceIntermediaires = null;
	private List<SavoirAssocie> savoirAssocie = null;
	private String savoirAssocies = null;

	public JTableCompetences(List<CompetenceIntermediaire> competenceIntermediaires, List<SavoirAssocie> savoirAssocies)
			throws BadLocationException {
		this();

		// set des composants
		setCompetenceIntermediaires(competenceIntermediaires);

		if (savoirAssocies != null) {
			setSavoirAssocie(savoirAssocies);
		}

		// ajout des composants
		affiche();
	}

	public JTableCompetences() throws BadLocationException {
		super();

		// ajout du layout
		setLayout(new GridBagLayout());

		// ajout des composants
		affiche();
	}

	public void affiche() throws BadLocationException {
		removeAll();
		jPanelSavoir = null;
		jPanelCompetence = null;

		if (getSavoirAssociesString() != null)
			add(getJPanelTiTle(), new GridBagConstraints(0, 0, 1, 1, 0.6, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		else
			add(getJPanelTiTle(), new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		if (getCompetenceIntermediaires() != null)
			add(getJPanelCompetence(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		if (getSavoirAssociesString() != null)
			add(getJPanelSavoir(), new GridBagConstraints(1, 0, 1, 3, 0.4, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		revalidate();
	}

	private JPanelSavoir jPanelSavoir = null;

	public JPanelSavoir getJPanelSavoir() throws BadLocationException {
		if (jPanelSavoir == null) {
			if (getSavoirAssociesString() != null)
				jPanelSavoir = new JPanelSavoir(getSavoirAssociesString(), this);
			else
				jPanelSavoir = new JPanelSavoir(this);
		}
		return jPanelSavoir;
	}

	private JPanelTiTle jPanelTiTle = null;

	private JPanelTiTle getJPanelTiTle() {
		if (jPanelTiTle == null)
			jPanelTiTle = new JPanelTiTle(this);
		return jPanelTiTle;
	}

	private JPanelCompetence jPanelCompetence = null;

	public JPanelCompetence getJPanelCompetence() throws BadLocationException {
		if (jPanelCompetence == null)
			jPanelCompetence = new JPanelCompetence(this);
		return jPanelCompetence;
	}

	public String getSavoirAssociesString() {
		return savoirAssocies;
	}

	private void setSavoirAssociesString(List<SavoirAssocie> savoirAssocies) {
		for (SavoirAssocie sav : savoirAssocies) {
			if (this.savoirAssocies == null)
				this.savoirAssocies = sav.toString();
			else
				this.savoirAssocies = this.savoirAssocies.concat(sav.toString());
		}
	}

	public List<CompetenceIntermediaire> getCompetenceIntermediaires() {
		return competenceIntermediaires;
	}

	public void setCompetenceIntermediaires(List<CompetenceIntermediaire> competenceIntermediaires) {
		this.competenceIntermediaires = competenceIntermediaires;
	}

	public void setSavoirAssocie(List<SavoirAssocie> savoirAssocie) {
		this.savoirAssocie = savoirAssocie;
		setSavoirAssociesString(this.savoirAssocie);
	}

}
