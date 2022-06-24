package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;

public interface StaffRepository extends CrudRepository<Staff, Long>{

	public Optional<SupportStaff> getSupportStaffByDni(String dni);
	@Query("select n"
            + " from Nurse n"
            + " where n.experience > :experience")
	public List<Nurse> getNurseWithMoreThanNYearsExperience(@Param("experience")Integer experience);
	@Query("select ss.area"
            + " from SupportStaff ss"
            + " group by ss.area"
            + " order by count(ss.area) asc")
	public String getLessEmployeesSupportStaffArea();
	@Query("select s"
            + " from Staff s"
            + " where s.fullName like :name")
	public List<Staff> getStaffWithName(@Param("name")String name);
	@Query("select n"
            + " from Nurse n"
            + " where (select count(s) from Shot s where s.nurse = n) = 0")
	public List<Nurse> getNurseNotShot();

}
