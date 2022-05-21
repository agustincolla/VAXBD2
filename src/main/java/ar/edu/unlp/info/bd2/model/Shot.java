package ar.edu.unlp.info.bd2.model;

import java.util.Date;

public class Shot {
	Long id;
	Patient patient; 
	Vaccine vaccine; 
	Date date;
	Centre centre; 
	Nurse nurse;
	ShotCertificate shotCertificate;
	
	public ShotCertificate getShotCertificate() {
		return shotCertificate;
	}
	public void setShotCertificate(ShotCertificate shotCertificate) {
		this.shotCertificate = shotCertificate;
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
	

//	public Shot
	

}
