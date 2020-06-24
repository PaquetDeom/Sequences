package fr.paquet.activite;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-24T09:26:51.567+0200")
@StaticMetamodel(ActiviteStrategie.class)
public class ActiviteStrategie_ {
	public static volatile SingularAttribute<ActiviteStrategie, Long> id;
	public static volatile SingularAttribute<ActiviteStrategie, String> description;
	public static volatile SingularAttribute<ActiviteStrategie, Double> duree;
	public static volatile SingularAttribute<ActiviteStrategie, Strategie> strategie;
}
