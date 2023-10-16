package com.anilerc.healthify.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Entity(name = "Patient")
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Patient extends Person {
    @Id
    @SequenceGenerator(
            name = "patient_sequence",
            sequenceName = "patient_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "patient_sequence"
    )
    @Column(name = "patient_id", updatable = false)
    private Long id;

    @Setter
    @Past
    @NotNull
    private LocalDate dateOfBirth;

    @Setter
    private String address;

}
