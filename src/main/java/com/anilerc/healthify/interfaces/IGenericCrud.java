package com.anilerc.healthify.interfaces;

import org.springframework.data.domain.Page;

import java.util.List;

public interface IGenericCrud<T> {

    List<T> findAll();
    Page<T> findAllPaginated(int pageNumber, int pageSize);
    T findById(long id);
    void deleteById(long id);
    Long count();
    public void save(T t);

}
