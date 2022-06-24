package ar.edu.unlp.info.bd2.repositories;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Shot;

public interface ShotRepository extends CrudRepository<Shot, Long>{
	@Query("select s"
            + " from Shot s"
            + " where s.date between :startDate and :endDate")
	public Stream<Shot> getShotsBetweenDates(@Param("startDate")Date startDate,@Param("endDate") Date endDate);
	
}
