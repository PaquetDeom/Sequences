package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-03-31T17:14:35.037+0200")
@StaticMetamodel(Savoir.class)
public class Savoir_ {
	public static volatile SingularAttribute<Savoir, Integer> id;
	public static volatile SingularAttribute<Savoir, String> code;
	public static volatile SingularAttribute<Savoir, String> intitule;
	public static volatile SingularAttribute<Savoir, Referentiel> referentiel;
	public static volatile ListAttribute<Savoir, Competence> competences;
	public static volatile ListAttribute<Savoir, SavoirAssocie> savoirsAssocies;
}