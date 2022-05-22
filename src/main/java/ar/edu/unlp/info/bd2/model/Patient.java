package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import org.hibernate.annotations.NaturalId;

@Entity
public class Patient implements Serializable {

	public Patient() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
    @NaturalId
    String email;
    
	String fullname;
	String password;
    
    @Temporal(TemporalType.TIMESTAMP)
	Date dayOfBirth;
    
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Shot> shots = new ArrayList<>();

	public List<Shot> getShots() {
		return shots;
	}

	public void setShots(ArrayList<Shot> shots) {
		this.shots = shots;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDayOfBirth() {
        Calendar cal = Calendar.getInstance();
		cal.setTime(dayOfBirth);
        return cal.getTime();
	}

	public void setDayOfBirth(Date dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient(String mail, String name, String pass, Date fecha) {
		this.setEmail(mail);
		this.setFullname(name);
		this.setPassword(pass);
		this.setDayOfBirth(fecha);
	}
}
