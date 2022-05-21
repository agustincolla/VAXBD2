package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;
import java.util.Date;

public class Patient {

	public Patient() {
	}

	Long id;
	String email;
	String fullname;
	String password;
	Date dayOfBirth;
	ArrayList<Shot> shots = new ArrayList<Shot>();

	public ArrayList<Shot> getShots() {
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
		return dayOfBirth;
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
