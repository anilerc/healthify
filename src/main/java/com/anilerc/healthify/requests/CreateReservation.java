package com.anilerc.healthify.requests;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateReservation(Long doctorId, Long patientId, LocalDate startTime, LocalDate endTime) {
}
