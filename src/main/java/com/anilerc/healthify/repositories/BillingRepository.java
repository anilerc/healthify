package com.anilerc.healthify.repositories;

import com.anilerc.healthify.models.Billing;
import com.anilerc.healthify.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    @Query("SELECT COUNT(r) FROM Billing r " +
            "WHERE r.patient_id = :patient " +
            "AND r.is_paid = false")
    int countUnpaidBillingRecords(@Param("patient") Long patientId);
}
