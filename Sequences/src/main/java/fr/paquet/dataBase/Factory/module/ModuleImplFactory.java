package fr.paquet.dataBase.Factory.module;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.ihm.alert.AlertType;
import fr.paquet.ihm.alert.AlertWindow;
import fr.paquet.module.ModuleImpl;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.sequence.SequenceImpl;

public class ModuleImplFactory extends Factory {

	public ModuleImpl findModuleImplByTitle(String title) throws Exception {

		Query query = Connect.getEm()
				.createQuery("SELECT moduleImpl FROM ModuleImpl moduleImpl WHERE moduleImpl.titre=:title");
		query.setParameter("title", title);

		try {
			ModuleImpl modImpl = (ModuleImpl) query.getSingleResult();
			return modImpl;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ModuleImpl> findModuleImplByReferentiel(Referentiel referentiel) throws Exception {
		Query query = Connect.getEm().createQuery(
				"SELECT moduleImpl FROM ModuleImpl moduleImpl WHERE moduleImpl.referentiel=:referentiel");
		query.setParameter("referentiel", referentiel);

		return (List<ModuleImpl>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {

		return ModuleImpl.class;
	}

	@Override
	public void removeObject(Object object) {
		try {
			remove(object);
		} catch (Exception e) {
			new AlertWindow(AlertType.ERREUR, "Connexion à la base Impossible");
			e.printStackTrace();
		}

	}

}
