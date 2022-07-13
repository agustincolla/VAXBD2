package ar.edu.unlp.info.bd2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unlp.info.bd2.model.SupportStaff;

public interface SupportStaffRepository extends CrudRepository<SupportStaff, Long> {
	public Optional<SupportStaff> getSupportStaffByDni(String dni);
	@Query("select ss.area"
            + " from SupportStaff ss"
            + " group by ss.area"
            + " order by count(ss.area) asc")
	public List<String> getLessEmployeesSupportStaffArea(Pageable page);
}
