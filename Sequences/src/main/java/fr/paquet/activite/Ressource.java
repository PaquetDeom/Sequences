package fr.paquet.activite;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ressource {

	@Id
	@GeneratedValue
	@Column(name = "REREID")
	public long Id = 0;

	@Column(name = "RERETE", length = 200)
	private String text = null;

	@Column(name = "REREUR", length = 500)
	private String url = null;

	@ManyToOne
	private Activite_1 activite = null;

	protected Ressource() {
		super();
	}

	protected Ressource(String text, String url, Activite_1 activite) throws Exception {
		this();

		setText(text);
		setUrl(url);
		setActivite(activite);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Activite_1 getActivite() {
		return activite;
	}

	private void setActivite(Activite_1 activite) {
		this.activite = activite;
	}

}
