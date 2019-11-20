package fr.paquet.dataBase.Factory.sequence;

import fr.paquet.dataBase.Factory.commun.Factory;
import fr.paquet.sequence.Sequence;

public class SequenceFactory extends Factory {

	@Override
	public Class<?> getClassObject() {
		return Sequence.class;
	}

}
