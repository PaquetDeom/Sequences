package fr.paquet.activite;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ActiviteStrategie {

	@Id
	@GeneratedValue
	@Column(name = "ACACID")
	private long id = 0;
	
	@Column(name = "ACACDE", length = 20)
	private String description = null;
	
	@Column(name = "ACACDU")
	private double duree = 0.0;
	
	@ManyToOne
	private Strategie strategie = null;
	
	public ActiviteStrategie() {
		super();
	}
	
	public ActiviteStrategie(String description, double duree, Strategie strategie) {
		super();
		
		setDescription(description);
		setDuree(duree);
		setStrategie(strategie);
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description.trim();
		this.description = description;
	}
	public double getDuree() {
		return duree;
	}
	public void setDuree(double duree) {
		this.duree = duree;
	}

	public Strategie getStrategie() {
		return strategie;
	}

	public void setStrategie(Strategie strategie) {
		this.strategie = strategie;
	}
	
	
}
