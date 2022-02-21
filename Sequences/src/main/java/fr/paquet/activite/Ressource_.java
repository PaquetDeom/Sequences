package fr.paquet.activite;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.787+0100")
@StaticMetamodel(Ressource.class)
public class Ressource_ {
	public static volatile SingularAttribute<Ressource, Long> Id;
	public static volatile SingularAttribute<Ressource, String> text;
	public static volatile SingularAttribute<Ressource, String> url;
	public static volatile SingularAttribute<Ressource, Activite_1> activite;
}
