package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.NaturalId;

@Entity
public class Centre implements Serializable {

	public Centre() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    
    @NaturalId
	String name;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	List<Staff> staff = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Staff> getStaffs() {
		return staff;
	}

	public void setStaffs(ArrayList<Staff> staffs) {
		this.staff = staffs;
	}

	public void addStaff(Staff p) {
		if(p.addCentre(this)) {
			this.getStaffs().add(p);	
		}	
	}

	public Centre(String name) {
		this.setName(name);
	}
}