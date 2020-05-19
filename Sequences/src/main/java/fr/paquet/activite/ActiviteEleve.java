package fr.paquet.activite;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import fr.paquet.dataBase.Factory.Activite.ActiviteEleveFactory;

@Entity
@Table(name = "ACTIVITEELV")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ACACID")),
		@AttributeOverride(name = "description", column = @Column(name = "ACACDE", length = 500)),
		@AttributeOverride(name = "duree", column = @Column(name = "ACACDU")) })
public class ActiviteEleve extends ActiviteStrategie {

	@SuppressWarnings("unused")
	private ActiviteEleve() {
		super();
	}

	public ActiviteEleve(Strategie strategie) throws Exception {
		super(null, 0.0, strategie);

		getStrategie().addActiviteEleve(this);
		new ActiviteEleveFactory().persist(this);
	}

}
