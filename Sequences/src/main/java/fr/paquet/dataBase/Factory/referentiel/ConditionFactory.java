package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.Condition;

public class ConditionFactory extends Factory {

	public ConditionFactory() {
		super();
	}

	@Override
	public Class<?> getClassObject() {
		
		return Condition.class;
	}
}
