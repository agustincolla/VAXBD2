package ar.edu.unlp.info.bd2.model;

public class Person {
	String dni; 
	String fullName;
	Long id;
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
}
