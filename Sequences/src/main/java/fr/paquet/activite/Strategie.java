package fr.paquet.activite;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.paquet.dataBase.Factory.Activite.StrategieFactory;

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

	@OneToOne
	private Activite_1 activite = null;

	public Strategie() {
		super();

	}

	public Strategie(Activite_1 activite) throws Exception {
		super();

		setActivite(activite);
		new StrategieFactory().persist(this);
	}

	public List<ActiviteEleve> getActiviteEleves() {
		if (activiteEleves == null)
			activiteEleves = new ArrayList<ActiviteEleve>();
		return activiteEleves;
	}

	public void addActiviteEleve(ActiviteEleve ActiviteEleve) {
		getActiviteEleves().add(ActiviteEleve);
	}

	public void setActiviteEleves(List<ActiviteEleve> activiteEleves) {
		this.activiteEleves = activiteEleves;
	}

	public List<ActiviteProf> getActiviteProfs() {
		if (activiteProfs == null)
			activiteProfs = new ArrayList<ActiviteProf>();
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

	public Activite_1 getActivite() {
		return activite;
	}

	public void setActivite(Activite_1 activite) {
		this.activite = activite;
	}
}
