package com.anilerc.healthify.services;

import com.anilerc.healthify.exceptions.UserNotFoundException;
import com.anilerc.healthify.interfaces.IGenericCrud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class GenericService<T> implements IGenericCrud<T> {

    private final JpaRepository<T, Long> repo;

    public GenericService(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<T> findAllPaginated(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return repo.findAll(pageRequest);
    }

    @Override
    public T findById(long id) {
        return repo.findById(id).orElseThrow(() -> new UserNotFoundException("Resource not found."));
    }

    @Override
    public void deleteById(long id) {
        repo.deleteById(id);
    }

    @Override
    public Long count() {
        return repo.count();
    }

    @Override
    public void save(T t) {
        repo.save(t);
    }
}
