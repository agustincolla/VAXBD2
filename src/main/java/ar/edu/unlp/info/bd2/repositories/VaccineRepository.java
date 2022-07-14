package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long>{
    
	public Vaccine save(Vaccine vaccine);
	public Optional<Vaccine> getVaccineByName(String name);
	@Query("select v"
            + " from Vaccine v"
            + " where (select count(s) from Shot s where s.vaccine = v) = 0")
	public List<Vaccine> getUnappliedVaccines();
}
