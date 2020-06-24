package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-24T09:26:51.622+0200")
@StaticMetamodel(Rap.class)
public class Rap_ {
	public static volatile SingularAttribute<Rap, Integer> id;
	public static volatile ListAttribute<Rap, Fonction> fonctions;
	public static volatile SingularAttribute<Rap, Referentiel> referentiel;
}
