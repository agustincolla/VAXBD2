package ar.edu.unlp.info.bd2.model;

public class Person {
	String dni; 
	String fullNam;
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
	public String getFullNam() {
		return fullNam;
	}
	/**
	 * @param fullNam el nombre
	 */
	//modificar nombre de la persona
	public void setFullNam(String fullNam) {
		this.fullNam = fullNam;
	} 
}
