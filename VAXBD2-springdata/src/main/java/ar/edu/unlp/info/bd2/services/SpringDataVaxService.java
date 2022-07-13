package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ar.edu.unlp.info.bd2.model.Centre;
import ar.edu.unlp.info.bd2.model.Nurse;
import ar.edu.unlp.info.bd2.model.Patient;
import ar.edu.unlp.info.bd2.model.Shot;
import ar.edu.unlp.info.bd2.model.ShotCertificate;
import ar.edu.unlp.info.bd2.model.Staff;
import ar.edu.unlp.info.bd2.model.SupportStaff;
import ar.edu.unlp.info.bd2.model.VaccinationSchedule;
import ar.edu.unlp.info.bd2.model.Vaccine;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

public class SpringDataVaxService implements VaxService{
    @Autowired
    PatientRepository pr;
    @Autowired
    CentreRepository cr;
    @Autowired
    StaffRepository sr;
    @Autowired
    SupportStaffRepository ssr;
    @Autowired
    NurseRepository nr;
    @Autowired
    ShotCertificateRepository shcr;
    @Autowired
    ShotRepository shr;
    @Autowired
    VaccinationSchedulerRepository vsr;
    @Autowired
    VaccineRepository vr;
    
	@Override
    @Transactional
	public List<Patient> getAllPatients() {
		return pr.getAllPatients();
	}

	@Override
    @Transactional
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
		return nr.getNurseWithMoreThanNYearsExperience(years);
	}

	@Override
    @Transactional
	public List<Centre> getCentresTopNStaff(int n) {
		Pageable page= PageRequest.of(0, n);
		return cr.getCentresTopNStaff(page);
	}

	@Override
    @Transactional
	public Centre getTopShotCentre() {
		Pageable page= PageRequest.of(0, 1);
		return cr.getTopShotCentre(page).get(0);
	}

	@Override
    @Transactional
	public List<Nurse> getNurseNotShot() {
		return nr.getNurseNotShot();
	}

	@Override
    @Transactional
	public String getLessEmployeesSupportStaffArea() {
		Pageable page= PageRequest.of(0, 1);
		return ssr.getLessEmployeesSupportStaffArea(page).get(0);
	}

	@Override
    @Transactional
	public List<Staff> getStaffWithName(String name) {
		return sr.getStaffWithName(name);
	}

	@Override
    @Transactional
	public List<Vaccine> getUnappliedVaccines() {
		return vr.getUnappliedVaccines();
	}

	@Override
    @Transactional
	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		Stream<Shot> shots = shr.getShotsBetweenDates(startDate, endDate);
        return shots.map(s -> s.getShotCertificate()).collect(Collectors.toList());
	}

	@Override
    @Transactional
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		Patient p= new Patient(email,fullname,password,dayOfBirth);
        try {
            pr.saveAndFlush(p);
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
		return p;
	}

	@Override
    @Transactional
	public Vaccine createVaccine(String name) throws VaxException {
		Vaccine v=new Vaccine(name);
        try {
            vr.saveAndFlush(v);
        } catch (DataIntegrityViolationException e) {
            throw new VaxException("Constraint Violation");
        }
		return v;
	}

	@Override
    @Transactional
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse)
			throws VaxException {
		Shot s=new Shot(patient,vaccine,date,centre,nurse);
        shcr.save(s.getShotCertificate());
		shr.save(s);
		patient.getShots().add(s);
		return s;
	}

	@Override
    @Transactional
	public Optional<Patient> getPatientByEmail(String email) {
		return pr.getPatientByEmail(email);
	}

	@Override
    @Transactional
	public Optional<Vaccine> getVaccineByName(String name) {
		return vr.getVaccineByName(name);
	}

	@Override
    @Transactional
	public Centre createCentre(String name) throws VaxException {
		Centre c=new Centre(name);
		cr.save(c);
		return c;
	}

	@Override
    @Transactional
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		Nurse n=new Nurse(dni,fullName,experience);
		sr.save(n);
		return n;
	}

	@Override
    @Transactional
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		SupportStaff ss=new SupportStaff(dni,fullName,area);
		sr.save(ss);
		return ss;
	}

	@Override
    @Transactional
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		VaccinationSchedule vs=new VaccinationSchedule();
		vsr.save(vs);
		return vs;
	}

	@Override
    @Transactional
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		return vsr.getVaccinationScheduleById(id);
	}

	@Override
    @Transactional
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		return cr.getCentreByName(name);
	}

	@Override
    @Transactional
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		return (SupportStaff) sr.save(staff);
	}

	@Override
    @Transactional
	public Centre updateCentre(Centre centre) {
		return cr.save(centre);
	}

	@Override
    @Transactional
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return ssr.getSupportStaffByDni(dni);
	}

	@Override
    @Transactional
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
		return vsr.save(schedule);
	}

}
