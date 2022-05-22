package ar.edu.unlp.info.bd2.repositories;

import ar.edu.unlp.info.bd2.model.*;
import java.io.Serializable;
import java.util.List;
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
}
