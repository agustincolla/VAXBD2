package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import javax.persistence.PersistenceException;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class VaxRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Serializable save(Object guardar) throws VaxException {
        /*Session session;
        Transaction tx;
        Serializable s;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            s = session.save(guardar);
            tx.commit();
            return s;
        } catch (ConstraintViolationException cve) {
            throw new VaxException("Constraint Violation");
        }*/
        Session session = sessionFactory.getCurrentSession();
        try {
            Serializable s = session.save(guardar);
            session.flush();
            return s;
        } catch (PersistenceException pe) {
            throw new VaxException("Constraint Violation");
        }
    }
    
    public Centre updateCentre(Centre centre) {
        Session session = sessionFactory.getCurrentSession();
        session.update(centre);
        return centre;
    }
    
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vaccinationSchedule);
        return vaccinationSchedule;
    }
    
    public Optional<Patient> getPatientByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
        return session.bySimpleNaturalId(Patient.class).loadOptional(email);
	}
    
    public Optional<Vaccine> getVaccineByName(String name) {
		Session session = sessionFactory.getCurrentSession();
        return session.bySimpleNaturalId(Vaccine.class).loadOptional(name);
    }
    
    public Optional<Centre> getCentreByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.bySimpleNaturalId(Centre.class).loadOptional(name);
    }

    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        Session session = sessionFactory.getCurrentSession();
        return session.bySimpleNaturalId(SupportStaff.class).loadOptional(dni);
    }
    
    public VaccinationSchedule getVaccinationScheduleById(Long Id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(VaccinationSchedule.class, Id);
    }
    
    public List<Patient> getAllPatients() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select p from Patient p", Patient.class).getResultList();
    }
    
    public List<Nurse> getNurseWithMoreThanNYearsExperience(Integer experience) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select n"
                + " from Nurse n"
                + " where n.experience > :experience", Nurse.class)
            .setParameter("experience", experience)
            .getResultList();
    }
    
    public List<Centre> getCentresTopNStaff(Integer n) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select c"
                + " from Centre c"
                + " order by size(c.staff) desc", Centre.class)
            .getResultStream()
            .limit(n)
            .collect(Collectors.toList());
    }
    
    public Centre getTopShotCentre() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select c"
                + " from Centre c"
                + " order by (select count(s) from Shot s where s.centre = c)", Centre.class)
            .stream()
            .findFirst()
            .get();
    }
    
    public List<Nurse> getNurseNotShot() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select n"
                + " from Nurse n"
                + " where (select count(s) from Shot s where s.nurse = n) = 0", Nurse.class)
            .getResultList();
    }
    
    public String getLessEmployeesSupportStaffArea() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select ss.area"
                + " from SupportStaff ss"
                + " group by ss.area"
                + " order by count(ss.area) asc", String.class)
            .stream()
            .limit(1)
            .findFirst()
            .get();
    }
    
    public List<Staff> getStaffWithName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select s"
                + " from Staff s"
                + " where s.fullName like :name", Staff.class)
            .setParameter("name", "%" + name + "%")
            .getResultList();
    }
    
    public List<Vaccine> getUnappliedVaccines() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select v"
                + " from Vaccine v"
                + " where (select count(s) from Shot s where s.vaccine = v) = 0", Vaccine.class)
            .getResultList();
    }
    
    public Stream<Shot> getShotsBetweenDates(Date startDate, Date endDate) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(
                "select s"
                + " from Shot s"
                + " where s.date between :startDate and :endDate", Shot.class)
            .setParameter("startDate", startDate)
            .setParameter("endDate", endDate)
            .stream();
    }
}
