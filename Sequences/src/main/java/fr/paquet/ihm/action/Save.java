package fr.paquet.ihm.action;

import fr.paquet.activite.Activite_1;
import fr.paquet.dataBase.Connect;
import fr.paquet.dataBase.Factory.Activite.Activite_1Factory;
import fr.paquet.dataBase.Factory.sequence.SequenceVersionFactory;
import main.MainFrame;

public class Save {

	public Save() throws Exception {
		super();

		if (MainFrame.getUniqInstance().getSequenceVersion()
				.isModifiable(Connect.getPConnexion().getUser().getAuteur())) {
			SequenceVersionFactory pF = new SequenceVersionFactory();
			Activite_1Factory aF = new Activite_1Factory();

			pF.persist(MainFrame.getUniqInstance().getSequenceVersion());

			if (!MainFrame.getUniqInstance().getSequenceVersion().getActivites().isEmpty())
				for (Activite_1 act : MainFrame.getUniqInstance().getSequenceVersion().getActivites()) {
					aF.persist(act);
				}
		}
	}
}
