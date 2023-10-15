package com.anilerc.healthify.services;

import java.util.List;

public interface IGenericCrud<T> {

    List<T> findAll();
    T save(T entity);
    T findById(long id);
    void delete(T entity);
    void deleteById(long id);

}
