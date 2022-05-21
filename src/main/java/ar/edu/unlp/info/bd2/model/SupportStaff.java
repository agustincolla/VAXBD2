package ar.edu.unlp.info.bd2.model;

public class SupportStaff extends Person {
	String area;
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
