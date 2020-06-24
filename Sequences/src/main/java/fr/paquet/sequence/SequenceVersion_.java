package fr.paquet.sequence;

import fr.paquet.activite.Activite_1;
import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.SavoirAssocie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-24T09:26:51.647+0200")
@StaticMetamodel(SequenceVersion.class)
public class SequenceVersion_ {
	public static volatile SingularAttribute<SequenceVersion, Long> Id;
	public static volatile SingularAttribute<SequenceVersion, Integer> numVersion;
	public static volatile SingularAttribute<SequenceVersion, SequenceImpl> firstSequence;
	public static volatile SingularAttribute<SequenceVersion, SequenceVersion> previousParent;
	public static volatile SingularAttribute<SequenceVersion, String> contexte;
	public static volatile SingularAttribute<SequenceVersion, Boolean> dernier;
	public static volatile SingularAttribute<SequenceVersion, String> problematique;
	public static volatile SingularAttribute<SequenceVersion, String> prerequis;
	public static volatile SingularAttribute<SequenceVersion, String> elementsARetenir;
	public static volatile SingularAttribute<SequenceVersion, String> lien;
	public static volatile SingularAttribute<SequenceVersion, String> Eval;
	public static volatile SingularAttribute<SequenceVersion, String> classe;
	public static volatile SingularAttribute<SequenceVersion, Auteur> auteur;
	public static volatile SingularAttribute<SequenceVersion, Boolean> visible;
	public static volatile ListAttribute<SequenceVersion, SavoirAssocie> savoirAssocies;
	public static volatile ListAttribute<SequenceVersion, CompetenceIntermediaire> competenceIntermediaires;
	public static volatile ListAttribute<SequenceVersion, Activite_1> activites;
}
