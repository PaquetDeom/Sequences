package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-16T14:01:28.529+0200")
@StaticMetamodel(CompetenceIntermediaire.class)
public class CompetenceIntermediaire_ {
	public static volatile SingularAttribute<CompetenceIntermediaire, Integer> id;
	public static volatile SingularAttribute<CompetenceIntermediaire, Competence> comp;
	public static volatile SingularAttribute<CompetenceIntermediaire, Integer> code;
	public static volatile SingularAttribute<CompetenceIntermediaire, String> intitule;
	public static volatile ListAttribute<CompetenceIntermediaire, Condition> conditions;
	public static volatile ListAttribute<CompetenceIntermediaire, CritereEvaluation> critereEvaluations;
}
