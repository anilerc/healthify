package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.repositories.DoctorRepository;
import com.anilerc.healthify.repositories.PatientRepository;
import com.anilerc.healthify.utility.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final Crud<Patient> crud;
    private final PatientRepository repo;

    @Autowired
    public PatientService(Crud<Patient> crud, PatientRepository repo) {
        this.crud = crud;
        this.repo = repo;
    }

    public List<Patient> getPatients() {
        return crud.getAll(repo);
    }

    public Page<Patient> getPatients(int pageNumber, int pageSize) {
        return crud.getAllPaginated(repo, pageNumber, pageSize);
    }

    public Patient getPatientById(Long id) {
        return crud.getById(repo, id);
    }

    public void addPatient(Patient p) {
        crud.save(repo, p);
    }


}
