package com.anilerc.healthify.models;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Entity
@Table(name = "Doctor")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Doctor extends Person {
    @Id
    @SequenceGenerator(
            name = "doctor_sequence",
            sequenceName = "doctor_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "doctor_sequence"
    )
    @Column(name = "doctor_id", updatable = false)
    private Long id;

    @Setter
    private String specialization;

    @Setter
    private int experienceYears;

    @Setter
    private double averageRating;

}
