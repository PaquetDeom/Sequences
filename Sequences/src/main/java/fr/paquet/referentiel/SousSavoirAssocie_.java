package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-24T09:26:51.633+0200")
@StaticMetamodel(SousSavoirAssocie.class)
public class SousSavoirAssocie_ {
	public static volatile SingularAttribute<SousSavoirAssocie, Integer> id;
	public static volatile SingularAttribute<SousSavoirAssocie, SavoirAssocie> savAss;
	public static volatile SingularAttribute<SousSavoirAssocie, Integer> code;
	public static volatile SingularAttribute<SousSavoirAssocie, String> intitule;
	public static volatile SingularAttribute<SousSavoirAssocie, Integer> niveau;
}
