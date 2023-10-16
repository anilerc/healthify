package com.anilerc.healthify.repositories;

import com.anilerc.healthify.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT COUNT(r) FROM Reservation r " +
            "WHERE r.patient = :patient " +
            "AND r.startTime <= :end " +
            "AND r.endTime >= :start")
    int countReservationsInTimeInterval(@Param("patient") Patient patient,
                                        @Param("start") LocalDateTime start,
                                        @Param("end") LocalDateTime end);
}
