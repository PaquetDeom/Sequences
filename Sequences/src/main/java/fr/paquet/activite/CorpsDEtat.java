package fr.paquet.activite;

import javax.persistence.*;

import fr.paquet.referentiel.Referentiel;

@Entity
@Table(name = "CORPSDETATS")
public class CorpsDEtat {

	@Id
	@GeneratedValue
	@Column(name = "COCOID")	
	private long Id = 0;
	
	@Column(name = "COCOCO", length = 20)
	private String corpsDEtats = null;
	
	@Column(name = "COCOSI", length = 20)
	private String sigle = null ;
	
	@Transient
	private Referentiel ref = null;
	
	public CorpsDEtat() {
		super();
	}
	
	public CorpsDEtat(String corpsDEtats, String sigle) {
		super();
		
		setCorpsDEtats(corpsDEtats);
		setSigle(sigle);
	}
	
	public String getCorpsDEtats() {
		return corpsDEtats;
	}
	public void setCorpsDEtats(String corpsDEtats) {
		this.corpsDEtats = corpsDEtats;
	}
	public String getSigle() {
		return sigle;
	}
	public void setSigle(String sigle) {
		this.sigle = sigle;
	}
	public Referentiel getRef() {
		return ref;
	}
	public void setRef(Referentiel ref) {
		this.ref = ref;
	}
}
