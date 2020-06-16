package fr.paquet.referentiel;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-16T14:01:28.656+0200")
@StaticMetamodel(Tache.class)
public class Tache_ {
	public static volatile SingularAttribute<Tache, Integer> id;
	public static volatile SingularAttribute<Tache, Activite> activite;
	public static volatile SingularAttribute<Tache, String> code;
	public static volatile SingularAttribute<Tache, String> intitule;
	public static volatile SingularAttribute<Tache, Integer> niveau;
	public static volatile SingularAttribute<Tache, String> typeResponsabilite;
	public static volatile ListAttribute<Tache, Competence> competences;
}
