package com.anilerc.healthify.controllers;

import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.services.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Doctor>> getDoctors() {
        List<Doctor> doctors = doctorService.getDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Doctor>> getDoctors(@RequestParam(name = "pageNumber", defaultValue = "0") Integer pageNumber,
                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<Doctor> doctorPages = doctorService.getDoctors(pageNumber, pageSize);
        return new ResponseEntity<>(doctorPages, HttpStatus.OK);
    }


    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor d) {
        doctorService.addDoctor(d);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
}

