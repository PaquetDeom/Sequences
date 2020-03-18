package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-17T16:18:45.135+0100")
@StaticMetamodel(Fonction.class)
public class Fonction_ {
	public static volatile SingularAttribute<Fonction, Integer> id;
	public static volatile SingularAttribute<Fonction, String> intitule;
	public static volatile SingularAttribute<Fonction, Rap> rap;
	public static volatile ListAttribute<Fonction, Activite> activites;
}
