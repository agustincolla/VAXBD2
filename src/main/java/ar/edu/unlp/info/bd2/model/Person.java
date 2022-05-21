package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class Person {
	String dni; 
	String fullName;
	Long id;
	ArrayList<Centre> centres= new ArrayList<Centre>();
	public ArrayList<Centre> getCentres() {
		return centres;
	}
	public void setCentres(ArrayList<Centre> centres) {
		this.centres = centres;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	//retornar dni de la persona
	/**
	 * @return el dni
	 */
	public String getDni() {
		return dni;
	}
	//modificar dni de la persona
	/**
	 * @param dni el dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	/**
	 * @return el nombre de la persona
	 */
	//retornar nombre de la persona
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName el nombre
	 */
	//modificar nombre de la persona
	public void setFullName(String fullName) {
		this.fullName = fullName;
	} 
	public boolean addCentre(Centre c) {
		boolean ok=true;
		if(!centres.contains(c)) {
			this.getCentres().add(c);
		}
		else {
			ok=false;
		}
		return ok;
	}
}
