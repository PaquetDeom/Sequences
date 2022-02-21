package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.852+0100")
@StaticMetamodel(Activite.class)
public class Activite_ {
	public static volatile SingularAttribute<Activite, Integer> id;
	public static volatile SingularAttribute<Activite, String> intitule;
	public static volatile ListAttribute<Activite, Tache> taches;
	public static volatile SingularAttribute<Activite, Fonction> fonction;
}
