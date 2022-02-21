package fr.paquet.activite;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENT")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "REREID")),
		@AttributeOverride(name = "text", column = @Column(name = "RERETE", length = 200)),
		@AttributeOverride(name = "url", column = @Column(name = "REREUR", length = 500)) })
public class RessourceDocument extends Ressource {

	public RessourceDocument(String text, String url, Activite_1 activite) throws Exception {
		super(text, url, activite);

	}

	public RessourceDocument() {
		super();
	}
}
