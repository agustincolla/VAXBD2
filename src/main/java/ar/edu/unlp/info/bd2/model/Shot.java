package ar.edu.unlp.info.bd2.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.ManyToOne;

@Entity
public class Shot implements Serializable {

    public Shot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) {
        this.patient = patient;
        this.vaccine = vaccine;
        this.date = date;
        this.centre = centre;
        this.nurse = nurse;
    }

	public Shot() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
    
    @ManyToOne
	Patient patient;
    
    @ManyToOne
	Vaccine vaccine;
    
    @Column(name = "shot_date")
    @Temporal(TemporalType.TIMESTAMP)
	Date date;
    
    @ManyToOne
	Centre centre;
    
    @ManyToOne
	Nurse nurse;

	public ShotCertificate getShotCertificate() {
		return new ShotCertificate(0, date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Centre getCentre() {
		return centre;
	}

	public void setCentre(Centre centre) {
		this.centre = centre;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}
}
