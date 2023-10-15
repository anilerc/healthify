package com.anilerc.healthify.services;

import com.anilerc.healthify.exceptions.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericService<T> implements IGenericCrud<T>{

    private final JpaRepository<T, Long> repo;

    public GenericService(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }

    @Override
    public T save(T entity) {
        return repo.save(entity);
    }

    @Override
    public T findById(long id) {
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException("Not found"));
    }

    @Override
    public void delete(T entity) {
        repo.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }
}
