package fr.paquet.ihm.action;

import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import fr.paquet.sequence.SequenceVersion;

public class CompareSequenceWithDB {

	private boolean same = false;

	public CompareSequenceWithDB(SequenceVersion sequenceVersionAct) throws Exception {
		super();

		SequenceVersion sequenceVersionDB = new SequenceVersionFactory().findSequenceVersionBySequenceImplAndNVersion(
				sequenceVersionAct.getFirstSequence(), sequenceVersionAct.getnVersion());

		if (sequenceVersionAct == sequenceVersionDB)
			same = true;
	}

	public boolean isSame() {
		return same;
	}
}
