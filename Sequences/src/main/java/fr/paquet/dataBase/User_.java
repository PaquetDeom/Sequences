package fr.paquet.dataBase;

import fr.paquet.sequence.Auteur;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-24T09:26:51.599+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Long> Id;
	public static volatile SingularAttribute<User, String> utilisateur;
	public static volatile SingularAttribute<User, String> pass;
	public static volatile SingularAttribute<User, Auteur> auteur;
}
