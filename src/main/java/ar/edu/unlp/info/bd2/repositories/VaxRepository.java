package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.*;
import java.io.Serializable;
import java.util.Optional;

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
    
    public Optional<Patient> getPatientByEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
        try {
            Patient patient = session.createQuery(
                    "select p"
                    + " from Patient p"
                    + " where p.email = :email", Patient.class)
                .setParameter("email", email)
                .getSingleResult();
            return Optional.ofNullable(patient);
        } catch (Exception e) {
            return Optional.empty();
        }
	}
    
    public Optional<Vaccine> getVaccineByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Vaccine vaccine = session.createQuery(
                    "select v"
                    + " from Vaccine v"
                    + " where v.name = :name", Vaccine.class)
                .setParameter("name", name)
                .getSingleResult();
            return Optional.ofNullable(vaccine);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    
    public Optional<Centre> getCentreByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        try {
            Centre centre = session.createQuery(
                    "select c"
                    + " from Centre c"
                    + " where c.name = :name", Centre.class)
                .setParameter("name", name)
                .getSingleResult();
            return Optional.ofNullable(centre);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<SupportStaff> getSupportStaffByDni(String dni) {
        Session session = sessionFactory.getCurrentSession();
        try {
            SupportStaff supportStaff = session.createQuery(
                    "select sp"
                    + " from SupportStaff sp"
                    + " where sp.dni = :dni", SupportStaff.class)
                .setParameter("dni", dni)
                .getSingleResult();
            return Optional.ofNullable(supportStaff);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
    
    public VaccinationSchedule getVaccinationScheduleById(Long Id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(VaccinationSchedule.class, Id);
    }
}
