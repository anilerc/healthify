package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.repositories.DoctorRepository;
import com.anilerc.healthify.utility.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService extends GenericService<Doctor> {

    private final DoctorRepository repo;

    @Autowired
    public DoctorService(DoctorRepository repo) {
        super(repo);
        this.repo = repo;
    }



}