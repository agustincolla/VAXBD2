package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import org.hibernate.annotations.NaturalId;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Staff implements Serializable {

	public Staff() {
	}

    @NaturalId
	String dni;
    
	String fullName;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    
    @ManyToMany(mappedBy = "staff")
	List<Centre> centres = new ArrayList<>();

	public List<Centre> getCentres() {
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

	// retornar dni de la persona
	/**
	 * @return el dni
	 */
	public String getDni() {
		return dni;
	}

	// modificar dni de la persona
	/**
	 * @param dni el dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return el nombre de la persona
	 */
	// retornar nombre de la persona
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName el nombre
	 */
	// modificar nombre de la persona
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
