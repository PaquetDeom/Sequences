package fr.paquet.referentiel;

import fr.paquet.commun.Diplome;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-17T16:18:45.136+0100")
@StaticMetamodel(Referentiel.class)
public class Referentiel_ {
	public static volatile SingularAttribute<Referentiel, Integer> id;
	public static volatile SingularAttribute<Referentiel, Diplome> diplome;
	public static volatile SingularAttribute<Referentiel, Rap> rap;
	public static volatile ListAttribute<Referentiel, Capacite> capacites;
	public static volatile ListAttribute<Referentiel, Savoir> savoirs;
	public static volatile ListAttribute<Referentiel, Unite> unites;
	public static volatile SingularAttribute<Referentiel, String> url;
}
