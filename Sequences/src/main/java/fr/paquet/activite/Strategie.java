package fr.paquet.activite;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STRATEGIE")
public class Strategie {

	@Id
	@GeneratedValue
	@Column(name = "STSTID")
	private long iD = 0;

	@OneToMany(mappedBy = "strategie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ActiviteEleve> activiteEleves = null;

	@OneToMany(mappedBy = "strategie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<ActiviteProf> activiteProfs = null;

	@Enumerated(EnumType.STRING)
	private DemarchePedagogique demarchePedagogique = null;

	public Strategie() {
		super();
	}

	public List<ActiviteEleve> getActiviteEleves() {
		return activiteEleves;
	}

	public void addActiviteEleve(ActiviteEleve ActiviteEleve) {
		getActiviteEleves().add(ActiviteEleve);
	}

	public void setActiviteEleves(List<ActiviteEleve> activiteEleves) {
		this.activiteEleves = activiteEleves;
	}

	public List<ActiviteProf> getActiviteProfs() {
		return activiteProfs;
	}

	public void addActiviteProf(ActiviteProf activiteProf) {
		getActiviteProfs().add(activiteProf);
	}

	public void setActiviteProfs(List<ActiviteProf> activiteProfs) {
		this.activiteProfs = activiteProfs;
	}

	public DemarchePedagogique getDemarchePedagogique() {
		return demarchePedagogique;
	}

	public void setDemarchePedagogique(DemarchePedagogique demarchePedagogique) {
		this.demarchePedagogique = demarchePedagogique;
	}
}
