package com.anilerc.healthify.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "billing")
@Table
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Billing {
    @Id
    @SequenceGenerator(
            name = "billing_sequence",
            sequenceName = "billing_sequence",
            allocationSize = 1)

    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "billing_sequence"
    )
    @Column(name = "billing_id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_billing_id",
            nullable = false,
            referencedColumnName = "reservation_id",
            foreignKey = @ForeignKey(name = "billing_reservation_fk"))
    private Reservation reservation;

    private Double amount;

    private Boolean isPaid;


}
