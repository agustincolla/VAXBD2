package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long>{

	public Patient save(Patient patient);
	public Optional<Patient> getPatientByEmail(String email);
	@Query("select p from Patient p")
	public List<Patient> getAllPatients();
}
