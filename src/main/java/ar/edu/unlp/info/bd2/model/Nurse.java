package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class Nurse extends Person {
	Integer experience;
	ArrayList<Centre> centres= new ArrayList<Centre>();
    public ArrayList<Centre> getCentres() {
		return centres;
	}
	public void setCentres(ArrayList<Centre> centres) {
		this.centres = centres;
	}
	//retornar años de experiencia del/la enfermero/a
	/**
	 * @return años de experiencia
	 */
	public Integer getExperience() {
		return experience;
	}
	//modificar años de experiencia del/la enfermero/a
	/**
	 * @param experience años de experiencia
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
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
	//crea un/a enfermero/a con los parametros recibidos 
	/**
	 * @param dni el dni
	 * @param fullName nombre del/la enfermero/a
	 * @param experience experiencia en años
	 * @return el enfermero creado
	 */
	public Nurse(String dni, String fullName, Integer experience) {
		this.setDni(dni);
		this.setFullName(fullName);
		this.setExperience(experience);
	}
	
}
