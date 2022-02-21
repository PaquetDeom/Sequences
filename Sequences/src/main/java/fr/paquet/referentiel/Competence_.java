package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.868+0100")
@StaticMetamodel(Competence.class)
public class Competence_ {
	public static volatile SingularAttribute<Competence, Integer> id;
	public static volatile SingularAttribute<Competence, Capacite> cap;
	public static volatile SingularAttribute<Competence, Boolean> transversal;
	public static volatile SingularAttribute<Competence, Unite> unite;
	public static volatile SingularAttribute<Competence, Integer> code;
	public static volatile SingularAttribute<Competence, String> intitule;
	public static volatile ListAttribute<Competence, CompetenceIntermediaire> competencesIntermediaires;
	public static volatile ListAttribute<Competence, Condition> conditions;
	public static volatile ListAttribute<Competence, CritereEvaluation> critereEvaluations;
	public static volatile ListAttribute<Competence, Savoir> savoirs;
	public static volatile ListAttribute<Competence, Tache> taches;
}
