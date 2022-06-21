package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Transient;

@Entity
public class VaccinationSchedule implements Serializable {

	public VaccinationSchedule() {
        this.vaccines = new ArrayList<>();
	}

    @ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderColumn(name = "pos")
	List<Vaccine> vaccines;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long Id;

	public List<Vaccine> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Vaccine> vaccines) {
		this.vaccines = vaccines;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void addVaccine(Vaccine va) {
		this.getVaccines().add(va);
	}
}

