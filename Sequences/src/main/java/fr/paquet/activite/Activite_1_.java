package fr.paquet.activite;

import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import fr.paquet.sequence.SequenceVersion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-10-21T11:49:43.063+0200")
@StaticMetamodel(Activite_1.class)
public class Activite_1_ {
	public static volatile SingularAttribute<Activite_1, Long> id;
	public static volatile SingularAttribute<Activite_1, Integer> nActivite;
	public static volatile SingularAttribute<Activite_1, SequenceVersion> sequence;
	public static volatile SingularAttribute<Activite_1, String> contexte;
	public static volatile SingularAttribute<Activite_1, String> questionnement;
	public static volatile ListAttribute<Activite_1, CorpsDEtat> corpsDetatsConcernes;
	public static volatile ListAttribute<Activite_1, SavoirAssocie> savoirAssocies;
	public static volatile ListAttribute<Activite_1, CompetenceIntermediaire> competencesIntermédiaires;
	public static volatile SingularAttribute<Activite_1, Strategie> strategie;
	public static volatile ListAttribute<Activite_1, RessourceDocument> documents;
	public static volatile ListAttribute<Activite_1, RessourceRessouces> ressources;
	public static volatile ListAttribute<Activite_1, RessourceTrace> traces;
}
