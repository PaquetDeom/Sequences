package fr.paquet.sequence;

import java.util.List;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.progression.Progression;
import fr.paquet.referentiel.Referentiel;

public class SequenceFactory extends Connect {

	/**
	 * 
	 * @return La liste des sequences d'une progression<br/>
	 */
	@SuppressWarnings("unchecked")
	public List<Sequence> findAllSequences(Referentiel referentiel) {
		Query query = getEm().createQuery("SELECT seq FROM Sequence seq where seq.referentiel=:referentiel");
		query.setParameter("referentiel", referentiel);
		return (List<Sequence>) query.getResultList();
	}

	/**
	 * 
	 * @return La liste des sequences d'une progression<br/>
	 */
	@SuppressWarnings("unchecked")
	public List<Sequence> findAllAuthorSequences(auteur auteur) {
		Query query = getEm().createQuery("SELECT seq FROM Sequence seq where seq.auteur=:auteur");
		query.setParameter("auteur", auteur);
		return (List<Sequence>) query.getResultList();
	}

	/**
	 * 
	 * @param prog
	 * @param titre
	 * @return Une sequence selon sa progression et son titre<br/>
	 */
	public static Sequence findSequence(Referentiel ref, String titre) {
		Query query = getEm()
				.createQuery("SELECT seq FROM Sequence seq where seq.refrentiel=:referentiel and seq.titre=:titre");
		query.setParameter("referentiel", ref);
		query.setParameter("titre", titre);
		return (Sequence) query.getSingleResult();
	}

	/**
	 * 
	 * @return toute les sequences de la table
	 */
	@SuppressWarnings("unchecked")
	public List<Sequence> findAllSequences() {
		Query query = getEm().createQuery("SELECT seq FROM Sequence");

		return (List<Sequence>) query.getResultList();
	}

	/**
	 * Sauvegarde d'une sequence<br/>
	 * 
	 * @param seq
	 */
	public void save(Sequence seq) {
		EntityTransaction t = getEm().getTransaction();
		try {

			t.begin();
			getEm().persist(seq);
			t.commit();

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}
	}

	/**
	 * supprime une sequence de la base de donne<br/>
	 * 
	 * @param seq
	 * @throws Exception
	 */
	public void removeSequence(Sequence seq) {

		EntityTransaction t = getEm().getTransaction();

		try {
			if (seq != null) {
				t.begin();
				getEm().remove(seq);
				t.commit();
			}

		} catch (Exception e) {
			t.rollback();
			throw (e);
		}
	}
}
