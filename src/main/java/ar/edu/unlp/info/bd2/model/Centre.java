package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class Centre {

    public Centre() {
    }
	Long id;
	String name;
	ArrayList<Person> staff = new ArrayList<Person> (); 
	
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
	
	public ArrayList<Person> getStaffs() {
		return staff;
	}
	public void setStaffs(ArrayList<Person> staffs) {
		this.staff = staffs;
	}
	
	public void addStaff (Person p){
		if (p.addCentre(this)){
			this.getStaffs().add(p);
		}
	}
	
	public Centre (String name) {
		this.setName(name);
	}
}
