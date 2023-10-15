package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.repositories.DoctorRepository;
import com.anilerc.healthify.utility.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final Crud<Doctor> crud;
    private final DoctorRepository repo;

    @Autowired
    public DoctorService(Crud<Doctor> crud, DoctorRepository repo) {
        this.crud = crud;
        this.repo = repo;
    }

    public List<Doctor> getDoctors() {
        return crud.getAll(repo);
    }

    public Page<Doctor> getDoctors(int pageNumber, int pageSize) {
        return crud.getAllPaginated(repo, pageNumber, pageSize);
    }

    public Doctor getDoctorById(Long id) {
        return crud.getById(repo, id);
    }

    public void addDoctor(Doctor d) {
        crud.save(repo, d);
    }


}