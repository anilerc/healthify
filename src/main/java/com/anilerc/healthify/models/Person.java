package com.anilerc.healthify.models;

import com.anilerc.healthify.utility.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@MappedSuperclass
public class Person {

    @Column(nullable = false)
    @NotBlank
    @Setter
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    @Setter
    private String lastName;

    @Column(nullable = false, unique = true)
    @Email
    @Setter
    private String email;

    @NotNull
    @Setter
    private String phoneNumber;

    @NotNull
    private Gender gender;

    public Person() {

    }

    public Person(String firstName, String lastName, String email, String phoneNumber, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }


}
