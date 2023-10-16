package com.anilerc.healthify.interfaces;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IGenericCrud<T> {

    List<T> findAll();
    Page<T> findAllPaginated(int pageNumber, int pageSize);
    T save(T entity);
    T findById(long id);
    void delete(T entity);
    void deleteById(long id);
    Long count();

}
