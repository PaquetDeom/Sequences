package fr.paquet.sequence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-22T09:29:01.869+0200")
@StaticMetamodel(SequenceVersion.class)
public class SequenceVersion_ {
	public static volatile SingularAttribute<SequenceVersion, Integer> numVersion;
	public static volatile SingularAttribute<SequenceVersion, Sequence> previousVersion;
	public static volatile SingularAttribute<SequenceVersion, String> contexte;
}
