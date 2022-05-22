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

@Entity
public class Centre implements Serializable {

	public Centre() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    
	String name;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	List<Person> staff = new ArrayList<>();

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

	public List<Person> getStaffs() {
		return staff;
	}

	public void setStaffs(ArrayList<Person> staffs) {
		this.staff = staffs;
	}

	public void addStaff(Person p) {
		staff.add(p);
        p.getCentres().add(this);
	}

	public Centre(String name) {
		this.setName(name);
	}
}
