package fr.paquet.commun;

import fr.paquet.dataBase.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-06-16T14:01:28.424+0200")
@StaticMetamodel(personne.class)
public class personne_ {
	public static volatile SingularAttribute<personne, Long> id;
	public static volatile SingularAttribute<personne, String> nom;
	public static volatile SingularAttribute<personne, String> prenom;
	public static volatile ListAttribute<personne, User> users;
}
