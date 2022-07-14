package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Long> {
	@Query("select n"
            + " from Nurse n"
            + " where n.experience > :experience")
	public List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("experience")Integer experience);
	@Query("select n"
            + " from Nurse n"
            + " where (select count(s) from Shot s where s.nurse = n) = 0")
	public List<Nurse> getNurseNotShot();
}
