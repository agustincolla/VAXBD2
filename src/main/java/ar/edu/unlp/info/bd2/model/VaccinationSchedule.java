package ar.edu.unlp.info.bd2.model;

import java.util.ArrayList;

public class VaccinationSchedule {
 ArrayList<Vaccine> vaccines;
 Long Id;
  
 // getVaccines()
public ArrayList<Vaccine> getVaccines() {
	return vaccines;
}
// setVaccine ()
public void setVaccines(ArrayList<Vaccine> vaccine) {
	this.vaccines = vaccine;
}
//getId()
public Long getId() {
	return Id;
}
// setId
public void setId(Long id) {
	Id = id;
}
public void addVaccine(Vaccine va) {
	this.getVaccines().add(va);
}

public VaccinationSchedule(ArrayList<Vaccine> vaxs)  {
	this.setVaccines(vaxs);
}
}
