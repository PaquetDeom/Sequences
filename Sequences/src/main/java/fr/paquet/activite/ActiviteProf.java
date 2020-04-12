package fr.paquet.activite;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVITEELV")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ACACID")),
		@AttributeOverride(name = "description", column = @Column(name = "ACACDE", length = 20)),
		@AttributeOverride(name = "duree", column = @Column(name = "ACACDU")) })
public class ActiviteProf extends ActiviteStrategie {

	public ActiviteProf() {
		super();
	}

}
