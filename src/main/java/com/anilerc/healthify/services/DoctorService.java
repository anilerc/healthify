package com.anilerc.healthify.services;

import com.anilerc.healthify.exceptions.UserNotFoundException;
import com.anilerc.healthify.models.Doctor;
import com.anilerc.healthify.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    // for doctor-specific repository actions
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }

    public Page<Doctor> getDoctors(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return doctorRepository.findAll(pageRequest);
    }


    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Doctor not found."));
    }

    public void addDoctor(Doctor d) {
        doctorRepository.save(d);
    }

}
