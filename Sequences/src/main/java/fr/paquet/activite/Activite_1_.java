package fr.paquet.activite;

import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.Sequence;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-10T15:46:40.378+0200")
@StaticMetamodel(Activite_1.class)
public class Activite_1_ {
	public static volatile SingularAttribute<Activite_1, Long> id;
	public static volatile SingularAttribute<Activite_1, Integer> nActivite;
	public static volatile SingularAttribute<Activite_1, Sequence> sequence;
	public static volatile SingularAttribute<Activite_1, String> contexte;
	public static volatile SingularAttribute<Activite_1, String> document;
	public static volatile SingularAttribute<Activite_1, String> ressources;
	public static volatile SingularAttribute<Activite_1, String> trace;
	public static volatile SingularAttribute<Activite_1, String> questionnement;
	public static volatile SingularAttribute<Activite_1, Object> corpsDetatsConcernes;
	public static volatile ListAttribute<Activite_1, SavoirAssocie> savoirAssocies;
	public static volatile ListAttribute<Activite_1, CompetenceIntermediaire> competencesIntermédiaires;
	public static volatile SingularAttribute<Activite_1, Strategie> strategie;
}
