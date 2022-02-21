package fr.paquet.dataBase.Factory.module;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.module.ModuleImpl;
import fr.paquet.module.ModuleVersion;
import fr.paquet.sequence.SequenceImpl;
import fr.paquet.sequence.SequenceVersion;

public class ModuleVersionFactory extends Factory {

	public ModuleVersion findModuleVersionByModuleImplAndNVersion(ModuleImpl firstModule, int numVersion)
			throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT moduleVersion FROM ModuleVersion moduleVersion WHERE moduleVersion.firstModule=:firstModule AND moduleVersion.numVersion=:numVersion");
		query.setParameter("firstModule", firstModule);
		query.setParameter("numVersion", numVersion);

		try {
			ModuleVersion moduleVersion = (ModuleVersion) query.getSingleResult();
			return moduleVersion;
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ModuleVersion> findModuleVersionByModuleImpl(ModuleImpl firstModule) throws Exception {

		Query query = Connect.getEm().createQuery(
				"SELECT moduleVersion FROM ModuleVersion moduleVersion WHERE moduleVersion.firstModule=:firstModule");
		query.setParameter("firstModuel", firstModule);

		return (List<ModuleVersion>) query.getResultList();
	}

	@Override
	public Class<?> getClassObject() {

		return ModuleVersion.class;
	}

	@Override
	public void removeObject(Object object) {
		// TODO
	}

}
