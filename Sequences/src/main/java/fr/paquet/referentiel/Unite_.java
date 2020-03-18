package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-17T16:18:45.139+0100")
@StaticMetamodel(Unite.class)
public class Unite_ {
	public static volatile SingularAttribute<Unite, Integer> id;
	public static volatile SingularAttribute<Unite, Integer> code;
	public static volatile SingularAttribute<Unite, String> intitule;
	public static volatile ListAttribute<Unite, Competence> competences;
	public static volatile SingularAttribute<Unite, Referentiel> ref;
}
