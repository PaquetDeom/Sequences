package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.926+0100")
@StaticMetamodel(SavoirAssocie.class)
public class SavoirAssocie_ {
	public static volatile SingularAttribute<SavoirAssocie, Integer> id;
	public static volatile SingularAttribute<SavoirAssocie, Savoir> sav;
	public static volatile SingularAttribute<SavoirAssocie, Integer> code;
	public static volatile SingularAttribute<SavoirAssocie, String> intitule;
	public static volatile ListAttribute<SavoirAssocie, SousSavoirAssocie> sousSavoirsAssocies;
}
