package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Vaccine;

public interface VaccineRepository extends CrudRepository<Vaccine, Long>{

	public Optional<Vaccine> getVaccineByName(String name);
	@Query("select v"
            + " from Vaccine v"
            + " where (select count(s) from Shot s where s.vaccine = v) = 0")
	public List<Vaccine> getUnappliedVaccines();
}
