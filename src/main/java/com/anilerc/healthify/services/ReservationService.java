package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.models.Reservation;
import com.anilerc.healthify.requests.CreateReservation;
import com.anilerc.healthify.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repo;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public ReservationService(ReservationRepository repo, DoctorService doctorService, PatientService patientService) {
        this.repo = repo;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }


    public List<Reservation> getReservations() {
        return repo.findAll();
    }

    public void addNewReservation(CreateReservation body) {
        var d = doctorService.getDoctorById(body.doctorId());
        var p = patientService.getPatientById(body.patientId());

        Reservation r = new Reservation(p, d, body.startTime(), body.endTime());

        repo.save(r);

    }


}
