package ar.edu.unlp.info.bd2.repositories;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.VaccinationSchedule;

public interface VaccinationSchedulerRepository extends CrudRepository<VaccinationSchedule, Long>{
    
	public VaccinationSchedule save(VaccinationSchedule vaccinationSchedule);
	public VaccinationSchedule getVaccinationScheduleById(Long Id);
	//public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule);
}
