package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PatientService extends GenericService<Patient> {

    private final PatientRepository repo;

    @Autowired
    public PatientService(PatientRepository repo) {
        super(repo);
        this.repo = repo;
    }

    public boolean checkAvailability(Patient p, LocalDateTime start, LocalDateTime end) {
        return repo.countReservationsInTimeInterval(p, start, end) == 0;
    }

}
