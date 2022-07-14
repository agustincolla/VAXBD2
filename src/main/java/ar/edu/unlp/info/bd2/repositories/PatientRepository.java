package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Override
	public Patient save(Patient patient);
	public Optional<Patient> getPatientByEmail(String email);
	@Query("select p from Patient p")
	public List<Patient> getAllPatients();
}
