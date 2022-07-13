package ar.edu.unlp.info.bd2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Long>{
    @Override
    public Staff save(Staff staff);
	@Query("select s"
            + " from Staff s"
            + " where s.fullName like %:name%")
	public List<Staff> getStaffWithName(@Param("name")String name);

}
