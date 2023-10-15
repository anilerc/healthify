package com.anilerc.healthify.utility;

import com.anilerc.healthify.exceptions.UserNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Crud<T> {

    public List<T> getAll(JpaRepository<T, Long> repository) {
        return repository.findAll();
    }

    public Page<T> getAllPaginated(JpaRepository<T, Long> repository, int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return repository.findAll(pageRequest);
    }

    public T getById(JpaRepository<T, Long> repository, Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("Doctor not found."));
    }

    public void save(JpaRepository<T, Long> repository, T t) {
        repository.save(t);
    }
}