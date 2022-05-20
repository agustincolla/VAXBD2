package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class SupportStaff extends Person {
	String area;
	ArrayList<Centre> centres= new ArrayList<Centre>();
    public ArrayList<Centre> getCentres() {
		return centres;
	}
	public void setCentres(ArrayList<Centre> centres) {
		this.centres = centres;
	}
	//retornar area donde trabaja el personal de soporte
	/**
	 * @return area donde trabaja
	 */
	public String getArea() {
		return area;
	}
	//modificar area donde trabaja el personal de soporte
	/**
	 * @param area area donde trabaja
	 */
	public void setArea(String area) {
		this.area = area;
	}
	public void addCentre(Centre c) {
		this.getCentres().add(c);
	}
	
	/**
	* @param dni el dni
	* @param fullName nombre completo
	* @param area el area o areas de trabajo
	* @return el personal de apoyo creado
	* */
	public SupportStaff(String dni, String fullName, String area) {
		this.setDni(dni);
		this.setFullName(fullName);
		this.setArea(area);
	}
	
}
