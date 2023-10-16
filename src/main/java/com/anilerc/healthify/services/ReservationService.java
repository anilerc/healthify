package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Reservation;
import com.anilerc.healthify.repositories.ReservationRepository;
import com.anilerc.healthify.requests.CreateReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends GenericService<Reservation> {

    private final ReservationRepository repo;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public ReservationService(ReservationRepository repo, DoctorService doctorService, PatientService patientService) {
        super(repo);
        this.repo = repo;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

}
