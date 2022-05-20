package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class VaccinationSchedule {
 ArrayList<Vaccine> vaccine;
 Long Id;
  
 // getVaccines()
public ArrayList<Vaccine> getVaccine() {
	return vaccine;
}
// setVaccine ()
public void setVaccine(ArrayList<Vaccine> vaccine) {
	this.vaccine = vaccine;
}
//getId()
public Long getId() {
	return Id;
}
// setId
public void setId(Long id) {
	Id = id;
}

public VaccinationSchedule(ArrayList<Vaccine> vaxs)  {
	this.setVaccine(vaxs);
}
}
