package com.anilerc.healthify.services;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.models.Patient;
import com.anilerc.healthify.models.Reservation;
import com.anilerc.healthify.repositories.ReservationRepository;
import com.anilerc.healthify.requests.CreateReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationService extends GenericService<Reservation> {
    private final ReservationRepository repo;
    private final DoctorService doctorService;
    private final PatientService patientService;
    private final BillingService billingService;

    @Autowired
    public ReservationService(ReservationRepository repo, DoctorService doctorService, PatientService patientService, BillingService billingService) {
        super(repo);
        this.repo = repo;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.billingService = billingService;
    }

    public void save(CreateReservation r) {
        Doctor d = doctorService.findById(r.doctorId());
        Patient p = patientService.findById(r.patientId());

        if (checkTimeAvailability(p, d, r.startTime(), r.endTime())) {
            throw new RuntimeException("Select a different time interval!");
        }

        if (billingService.hasUnpaidBilling(p)) {
            throw new RuntimeException("First pay for the previous reservations!");
        }

        Reservation reservation = new Reservation(p, d, r.startTime(), r.endTime());

        repo.save(reservation);

    }

    private boolean checkTimeAvailability(Patient p, Doctor d, LocalDateTime start, LocalDateTime end) throws RuntimeException {
        return patientService.checkAvailability(p, start, end) && doctorService.checkAvailability(d, start, end);
    }


}
