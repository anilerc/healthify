package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DoctorService extends GenericService<Doctor> {

    private final DoctorRepository repo;

    @Autowired
    public DoctorService(DoctorRepository repo) {
        super(repo);
        this.repo = repo;
    }

    public boolean checkAvailability(Doctor d, LocalDateTime start, LocalDateTime end) {
        return repo.countReservationsInTimeInterval(d, start, end) == 0;
    }
}

