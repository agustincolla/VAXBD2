package ar.edu.unlp.info.bd2.model;

import javax.persistence.Entity;

@Entity
public class Nurse extends Staff {

	public Nurse() {
	}

	Integer experience;

	// retornar años de experiencia del/la enfermero/a
	/**
	 * @return años de experiencia
	 */
	public Integer getExperience() {
		return experience;
	}

	// modificar años de experiencia del/la enfermero/a
	/**
	 * @param experience años de experiencia
	 */
	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	// crea un/a enfermero/a con los parametros recibidos
	/**
	 * @param dni        el dni
	 * @param fullName   nombre del/la enfermero/a
	 * @param experience experiencia en años
	 * @return el enfermero creado
	 */
	public Nurse(String dni, String fullName, Integer experience) {
		this.setDni(dni);
		this.setFullName(fullName);
		this.setExperience(experience);
	}

}
