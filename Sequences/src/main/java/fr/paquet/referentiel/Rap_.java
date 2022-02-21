package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.905+0100")
@StaticMetamodel(Rap.class)
public class Rap_ {
	public static volatile SingularAttribute<Rap, Integer> id;
	public static volatile ListAttribute<Rap, Fonction> fonctions;
	public static volatile SingularAttribute<Rap, Referentiel> referentiel;
}
