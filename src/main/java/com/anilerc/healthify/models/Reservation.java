package com.anilerc.healthify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Entity(name = "Reservation")
@Table
@AllArgsConstructor
@ToString
public class Reservation {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "reservation_patient_id",
            nullable = false,
            referencedColumnName = "patient_id",
            foreignKey = @ForeignKey(name = "reservation_patient_fk")
    )
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "reservation_doctor_id",
            nullable = false,
            referencedColumnName = "doctor_id",
            foreignKey = @ForeignKey(name = "reservation_doctor_fk")
    )
    private Doctor doctor;


    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "reservation_sequence"
    )
    @Column(name = "reservation_id", updatable = false)
    private Long id;

    private LocalDate startTime;

    private LocalDate endTime;


    @Autowired
    public Reservation(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    public Reservation(){

    }

    public Reservation(Patient patient, Doctor doctor, LocalDate startTime, LocalDate endTime) {
        this.patient = patient;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
