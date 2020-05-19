package fr.paquet.activite;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.paquet.dataBase.Factory.Activite.ActiviteProfFactory;

@Entity
@Table(name = "ACTIVITEPROF")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ACACID")),
		@AttributeOverride(name = "description", column = @Column(name = "ACACDE", length = 500)),
		@AttributeOverride(name = "duree", column = @Column(name = "ACACDU")) })
public class ActiviteProf extends ActiviteStrategie {

	@SuppressWarnings("unused")
	private ActiviteProf() {
		super();
	}

	public ActiviteProf(Strategie strategie) throws Exception {
		super(null, 0.0, strategie);

		getStrategie().addActiviteProf(this);
		new ActiviteProfFactory().persist(this);
	}

}
