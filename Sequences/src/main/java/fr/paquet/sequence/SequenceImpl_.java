package fr.paquet.sequence;

import fr.paquet.referentiel.Capacite;
import fr.paquet.referentiel.Referentiel;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2022-01-31T09:55:30.965+0100")
@StaticMetamodel(SequenceImpl.class)
public class SequenceImpl_ {
	public static volatile SingularAttribute<SequenceImpl, Long> id;
	public static volatile SingularAttribute<SequenceImpl, String> titre;
	public static volatile SingularAttribute<SequenceImpl, Referentiel> referentiel;
	public static volatile SingularAttribute<SequenceImpl, Boolean> modifiable;
	public static volatile SingularAttribute<SequenceImpl, Integer> nVersion;
	public static volatile SingularAttribute<SequenceImpl, Capacite> capacite;
}
