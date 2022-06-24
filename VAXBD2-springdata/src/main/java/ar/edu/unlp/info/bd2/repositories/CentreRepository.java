package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.Centre;

public interface CentreRepository extends CrudRepository<Centre, Long> {
    
	public Centre save(Centre centre);
	public Centre updateCentre(Centre centre);
	public Optional<Centre> getCentreByName(String name);
	@Query("select c"+
           "from Centre c"+
           "order by size(c.staff) desc")
	public List<Centre> getCentresTopNStaff(Integer n);
	@Query("select s.centre"
            + " from Shot s"
            + " group by s.centre"
            + " order by count(s) desc")
	public Centre getTopShotCentre();
	
}
