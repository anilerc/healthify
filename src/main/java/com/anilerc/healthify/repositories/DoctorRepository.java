package com.anilerc.healthify.repositories;

import com.anilerc.healthify.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT COUNT(r) FROM Reservation r " +
            "WHERE r.doctor = :doctor " +
            "AND r.startTime <= :end " +
            "AND r.endTime >= :start")
    int countReservationsInTimeInterval(@Param("doctor") Doctor doctor,
                                        @Param("start") LocalDateTime start,
                                        @Param("end") LocalDateTime end);
}
