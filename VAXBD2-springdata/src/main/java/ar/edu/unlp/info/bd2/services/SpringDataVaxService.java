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

public class SpringDataVaxService implements VaxService{
    @Autowired
    PatientRepository pr;
    @Autowired
    CentreRepository cr;
    @Autowired
    StaffRepository sr;
    @Autowired
    ShotCertificateRepository shcr;
    @Autowired
    ShotRepository shr;
    @Autowired
    VaccinationSchedulerRepository vsr;
    @Autowired
    VaccineRepository vr;
	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return pr.getAllPatients();
	}

	@Override
	public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
		// TODO Auto-generated method stub
		return sr.getNurseWithMoreThanNYearsExperience(years);
	}

	@Override
	public List<Centre> getCentresTopNStaff(int n) {
		// TODO Auto-generated method stub
		Pageable page= PageRequest.of(0, n);
		return cr.getCentresTopNStaff(page);
	}

	@Override
	public Centre getTopShotCentre() {
		// TODO Auto-generated method stub
		Pageable page= PageRequest.of(0, 1);
		return cr.getTopShotCentre(page).get(0);
	}

	@Override
	public List<Nurse> getNurseNotShot() {
		// TODO Auto-generated method stub
		return sr.getNurseNotShot();
	}

	@Override
	public String getLessEmployeesSupportStaffArea() {
		// TODO Auto-generated method stub
		Pageable page= PageRequest.of(0, 1);
		return sr.getLessEmployeesSupportStaffArea(page).get(0);
	}

	@Override
	public List<Staff> getStaffWithName(String name) {
		// TODO Auto-generated method stub
		return sr.getStaffWithName(name);
	}

	@Override
	public List<Vaccine> getUnappliedVaccines() {
		// TODO Auto-generated method stub
		return vr.getUnappliedVaccines();
	}

	@Override
	public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		Stream<Shot> shots = shr.getShotsBetweenDates(startDate, endDate);
        return shots.map(s -> s.getShotCertificate()).collect(Collectors.toList());
	}

	@Override
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
		// TODO Auto-generated method stub
		Patient p= new Patient(email,fullname,password,dayOfBirth);
		pr.save(p);
		return p;
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		// TODO Auto-generated method stub
		Vaccine v=new Vaccine(name);
		vr.save(v);
		return v;
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse)
			throws VaxException {
		// TODO Auto-generated method stub
		Shot s=new Shot(patient,vaccine,date,centre,nurse);
		shr.save(s);
		patient.getShots().add(s);
		return s;
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		// TODO Auto-generated method stub
		return pr.getPatientByEmail(email);
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		// TODO Auto-generated method stub
		return vr.getVaccineByName(name);
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		// TODO Auto-generated method stub
		Centre c=new Centre(name);
		cr.save(c);
		return c;
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		// TODO Auto-generated method stub
		Nurse n=new Nurse(dni,fullName,experience);
		sr.save(n);
		return n;
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		// TODO Auto-generated method stub
		SupportStaff ss=new SupportStaff(dni,fullName,area);
		sr.save(ss);
		return ss;
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		// TODO Auto-generated method stub
		VaccinationSchedule vs=new VaccinationSchedule();
		vsr.save(vs);
		return vs;
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		// TODO Auto-generated method stub
		return vsr.getVaccinationScheduleById(id);
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		// TODO Auto-generated method stub
		return cr.getCentreByName(name);
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		// TODO Auto-generated method stub
		return (SupportStaff) sr.updateSupportStaff(staff);
	}

	@Override
	public Centre updateCentre(Centre centre) {
		// TODO Auto-generated method stub
		return cr.updateCentre(centre);
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		// TODO Auto-generated method stub
		return sr.getSupportStaffByDni(dni);
	}

	@Override
	public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule schedule) {
		// TODO Auto-generated method stub
		return vsr.updateVaccinationSchedule(schedule);
	}

}
