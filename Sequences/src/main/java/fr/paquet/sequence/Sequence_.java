package fr.paquet.sequence;

import fr.paquet.referentiel.CompetenceIntermediaire;
import fr.paquet.referentiel.Referentiel;
import fr.paquet.referentiel.SavoirAssocie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2020-04-02T16:32:01.117+0200")
@StaticMetamodel(Sequence.class)
public class Sequence_ {
	public static volatile SingularAttribute<Sequence, String> titre;
	public static volatile SingularAttribute<Sequence, Referentiel> referentiel;
	public static volatile SingularAttribute<Sequence, Auteur> auteur;
	public static volatile SingularAttribute<Sequence, String> problematique;
	public static volatile SingularAttribute<Sequence, String> prerequis;
	public static volatile SingularAttribute<Sequence, String> contexte;
	public static volatile SingularAttribute<Sequence, String> elementsARetenir;
	public static volatile SingularAttribute<Sequence, String> lien;
	public static volatile SingularAttribute<Sequence, String> Eval;
	public static volatile ListAttribute<Sequence, CompetenceIntermediaire> competenceIntermediaires;
	public static volatile ListAttribute<Sequence, SavoirAssocie> savoirAssocies;
	public static volatile SingularAttribute<Sequence, Long> id;
}
