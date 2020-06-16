package fr.paquet.activite;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-16T14:01:28.317+0200")
@StaticMetamodel(Ressource.class)
public class Ressource_ {
	public static volatile SingularAttribute<Ressource, Long> Id;
	public static volatile SingularAttribute<Ressource, String> text;
	public static volatile SingularAttribute<Ressource, String> url;
	public static volatile SingularAttribute<Ressource, Activite_1> activite;
}
