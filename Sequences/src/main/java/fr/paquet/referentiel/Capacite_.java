package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-31T17:14:35.033+0200")
@StaticMetamodel(Capacite.class)
public class Capacite_ {
	public static volatile SingularAttribute<Capacite, Integer> id;
	public static volatile SingularAttribute<Capacite, String> code;
	public static volatile SingularAttribute<Capacite, String> intitule;
	public static volatile SingularAttribute<Capacite, Referentiel> referentiel;
	public static volatile ListAttribute<Capacite, Competence> competences;
}
