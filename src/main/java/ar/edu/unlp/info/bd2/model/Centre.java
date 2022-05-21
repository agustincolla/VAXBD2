package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class Centre {
	Long id;
	String name;
	ArrayList<Nurse> nurses = new ArrayList<Nurse>();
	ArrayList<SupportStaff> staffs = new ArrayList<SupportStaff> (); 
	
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
	public ArrayList<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(ArrayList<Nurse> nurses) {
		this.nurses = nurses;
	}
	public ArrayList<SupportStaff> getStaffs() {
		return staffs;
	}
	public void setStaffs(ArrayList<SupportStaff> staffs) {
		this.staffs = staffs;
	}
	
	public void addStaff (SupportStaff staffAux){
		if (staffAux.addCentre(this)){
			this.getStaffs().add(staffAux);
		}
		
	}
	
	public void addNurse (Nurse nurse){
		if (nurse.addCentre(this)) {
			this.getNurses().add(nurse);
		}
	}
	
	public Centre (String name) {
		this.setName(name);
	}
}
