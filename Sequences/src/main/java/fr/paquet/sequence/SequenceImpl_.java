package fr.paquet.sequence;

import fr.paquet.activite.Activite_1;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-22T08:49:32.390+0200")
@StaticMetamodel(SequenceImpl.class)
public class SequenceImpl_ {
	public static volatile SingularAttribute<SequenceImpl, Long> id;
	public static volatile SingularAttribute<SequenceImpl, String> titre;
	public static volatile SingularAttribute<SequenceImpl, Auteur> auteur;
	public static volatile SingularAttribute<SequenceImpl, String> problematique;
	public static volatile SingularAttribute<SequenceImpl, String> prerequis;
	public static volatile SingularAttribute<SequenceImpl, String> contexte;
	public static volatile SingularAttribute<SequenceImpl, String> elementsARetenir;
	public static volatile SingularAttribute<SequenceImpl, String> lien;
	public static volatile SingularAttribute<SequenceImpl, String> Eval;
	public static volatile SingularAttribute<SequenceImpl, Boolean> visible;
	public static volatile SingularAttribute<SequenceImpl, Boolean> modifiable;
	public static volatile SingularAttribute<SequenceImpl, Integer> nVersion;
	public static volatile SingularAttribute<SequenceImpl, String> classe;
	public static volatile ListAttribute<SequenceImpl, Activite_1> activites;
}
