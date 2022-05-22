package ar.edu.unlp.info.bd2.services;

import java.util.Date;
import java.util.Optional;

import ar.edu.unlp.info.bd2.model.*;
import ar.edu.unlp.info.bd2.repositories.VaxException;
import ar.edu.unlp.info.bd2.repositories.VaxRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VaxServiceImpl implements VaxService {
    private VaxRepository repository;
    
    public VaxServiceImpl(VaxRepository repo) {
    	setRepository(repo);
    }
	//@Transactional
	public Patient createPatient(String email, String fullname, String password, Date dayOfBirth) throws VaxException {
        Patient patient = new Patient(email, fullname, password, dayOfBirth);
        repository.save(patient);
        return patient;
	}

	@Override
	public Vaccine createVaccine(String name) throws VaxException {
		Vaccine vaccine = new Vaccine(name);
        repository.save(vaccine);
        return vaccine;
	}

	@Override
	public Shot createShot(Patient patient, Vaccine vaccine, Date date, Centre centre, Nurse nurse) throws VaxException {
		Shot shot = new Shot(patient, vaccine, date, centre, nurse);
        repository.save(shot);
        patient.getShots().add(shot);
        return shot;
	}

	@Override
	public Optional<Patient> getPatientByEmail(String email) {
		return repository.getPatientByEmail(email);
	}

	@Override
	public Optional<Vaccine> getVaccineByName(String name) {
		return repository.getVaccineByName(name);
	}

	@Override
	public Centre createCentre(String name) throws VaxException {
		Centre centre = new Centre(name);
        repository.save(centre);
        return centre;
	}

	@Override
	public Nurse createNurse(String dni, String fullName, Integer experience) throws VaxException {
		Nurse nurse = new Nurse(dni, fullName, experience);
        repository.save(nurse);
        return nurse;
	}

	@Override
	public SupportStaff createSupportStaff(String dni, String fullName, String area) throws VaxException {
		SupportStaff supportStaff = new SupportStaff(dni, fullName, area);
        repository.save(supportStaff);
        return supportStaff;
	}

	@Override
	public VaccinationSchedule createVaccinationSchedule() throws VaxException {
		VaccinationSchedule vaccinationSchedule = new VaccinationSchedule();
        repository.save(vaccinationSchedule);
        return vaccinationSchedule;
	}

	@Override
	public VaccinationSchedule getVaccinationScheduleById(Long id) throws VaxException {
		return repository.getVaccinationScheduleById(id);
	}

	@Override
	public Optional<Centre> getCentreByName(String name) throws VaxException {
		return repository.getCentreByName(name);
	}

	@Override
	public SupportStaff updateSupportStaff(SupportStaff staff) throws VaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Centre updateCentre(Centre centre) {
		return repository.updateCentre(centre);
	}

	@Override
	public Optional<SupportStaff> getSupportStaffByDni(String dni) {
		return repository.getSupportStaffByDni(dni);
	}
	public VaxRepository getRepository() {
		return repository;
	}
	public void setRepository(VaxRepository repository) {
		this.repository = repository;
	}

    @Override
    public List<Patient> getAllPatients() {
        return repository.getAllPatients();
    }

    @Override
    public List<Nurse> getNurseWithMoreThanNYearsExperience(int years) {
        return repository.getNurseWithMoreThanNYearsExperience(years);
    }

    @Override
    public List<Centre> getCentresTopNStaff(int n) {
        return repository.getCentresTopNStaff(n);
    }

    @Override
    public Centre getTopShotCentre() {
        return repository.getTopShotCentre();
    }

    @Override
    public List<Nurse> getNurseNotShot() {
        return repository.getNurseNotShot();
    }

    @Override
    public String getLessEmployeesSupportStaffArea() {
        return repository.getLessEmployeesSupportStaffArea();
    }

    @Override
    public List<Staff> getStaffWithName(String name) {
        return repository.getStaffWithName(name);
    }

    @Override
    public List<Vaccine> getUnappliedVaccines() {
        return repository.getUnappliedVaccines();
    }

    @Override
    public List<ShotCertificate> getShotCertificatesBetweenDates(Date startDate, Date endDate) {
        Stream<Shot> shots = repository.getShotsBetweenDates(startDate, endDate);
        return shots.map(s -> s.getShotCertificate()).collect(Collectors.toList());
    }

    @Override
    public VaccinationSchedule updateVaccinationSchedule(VaccinationSchedule vaccinationSchedule) throws VaxException {
        return repository.updateVaccinationSchedule(vaccinationSchedule);
    }

}
