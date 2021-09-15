package com.kubrafelek.devpatika.service;

import java.util.List;

public interface BaseService<T> {

    List<T> findAll();

    T findById(int id);

    T save(T object);

    T update(T object, int id);

    String deleteById(int id);

}
