package fr.paquet.dataBase.Factory.sequence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.Auteur;
import fr.paquet.sequence.SequenceImpl;
import fr.paquet.sequence.SequenceVersion;
import main.MainFrame;

public class SequenceVersionFactory extends Factory {
	
	public SequenceVersion findSequenceVersionBySequenceImplAndNVersion(SequenceImpl firstSequence, int numVersion)
			throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.firstSequence=:firstSequence AND sequenceVersion.numVersion=:numVersion");
		query.setParameter("firstSequence", firstSequence);
		query.setParameter("numVersion", numVersion);

		try {
			SequenceVersion sequenceVersion = (SequenceVersion) query.getSingleResult();
			return sequenceVersion;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SequenceVersion> findSequenceVersionBySequenceImpl(SequenceImpl firstSequence) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.firstSequence=:firstSequence");
		query.setParameter("firstSequence", firstSequence);

		return (List<SequenceVersion>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SequenceVersion> findSequenceVersionByAuteur(Auteur auteur) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT sequenceVersion FROM SequenceVersion sequenceVersion WHERE sequenceVersion.auteur=:auteur");
		query.setParameter("auteur", auteur);

		return (List<SequenceVersion>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {
		return SequenceVersion.class;
	}

	public List<SequenceVersion> findSequenceByReferentiel(Referentiel referentiel) throws Exception {

		List<SequenceImpl> seqImpls = new SequenceImplFactory().findSequenceImplByReferentiel(referentiel);

		List<SequenceVersion> sequenceVersions = new ArrayList<SequenceVersion>();

		for (SequenceImpl seqImpl : seqImpls) {
			for (SequenceVersion seq : findSequenceVersionBySequenceImpl(seqImpl)) {
				if (seq.isVisible())
					sequenceVersions.add(seq);
			}
			;
		}

		return sequenceVersions;
	}

	@Override
	public void removeObject(Object object) {
		SequenceVersion seq = (SequenceVersion) object;

		try {
			if (MainFrame.getUniqInstance().getSequenceVersion() != null
					&& MainFrame.getUniqInstance().getSequenceVersion().equals(seq)) {
				MainFrame.getUniqInstance().initPanelOuverture();
			}

			if (seq.getParent() != null) {
				// rendre le parent dernier
				seq.getParent().unlock();
				// supprimer sequenceVersion
				remove(seq);

			} else {
				// supprimer sequenceVersion
				remove(seq);
				// Supprimer firstSequence si elle est dernière
				new SequenceImplFactory().removeObject(seq.getFirstSequence());

			}
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Connexion à la base Impossible");
			e.printStackTrace();
		}

	}

}
