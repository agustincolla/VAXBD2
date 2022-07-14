package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.NaturalId;

@Entity
public class Vaccine implements Serializable {

	public Vaccine() {
	}

    @NaturalId
	String name;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	// retorna el nombre de la vacuna
	/**
	 * @return el nombre de la vacuna
	 */
	public String getName() {
		return name;
	}

	// modificar el nombre de la vacuna
	/**
	 * @param name el nombre de la vacuna
	 */
	public void setName(String name) {
		this.name = name;
	}

	// retorna id de la vacuna
	/**
	 * @return el id de la vacuna
	 */
	public Long getId() {
		return id;
	}

	// modificar id de la vacuna
	/**
	 * @param id el id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	// crea una vacuna con los parametros recibidos
	/**
	 * @param id   con el id
	 * @param name nombre de la vacuna
	 */
	public Vaccine(String name) {
		this.setName(name);
	}
}

