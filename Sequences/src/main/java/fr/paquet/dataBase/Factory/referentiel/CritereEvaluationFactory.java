package fr.paquet.dataBase.Factory.referentiel;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.referentiel.CritereEvaluation;

public class CritereEvaluationFactory extends Factory {

	@Override
	public Class<?> getClassObject() {
		return CritereEvaluation.class;
	}
}
