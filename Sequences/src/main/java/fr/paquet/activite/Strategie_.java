package fr.paquet.activite;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.814+0100")
@StaticMetamodel(Strategie.class)
public class Strategie_ {
	public static volatile SingularAttribute<Strategie, Long> iD;
	public static volatile ListAttribute<Strategie, ActiviteEleve> activiteEleves;
	public static volatile ListAttribute<Strategie, ActiviteProf> activiteProfs;
	public static volatile SingularAttribute<Strategie, DemarchePedagogique> demarchePedagogique;
	public static volatile SingularAttribute<Strategie, Activite_1> activite;
}
