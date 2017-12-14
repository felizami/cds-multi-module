package com.anuz.cdsserver.dao;

import java.util.List;

public interface GenericDAO<T> {
    List<T> getAll();

    T getById(int id);

    int saveOrUpdate(T t);

    int delete(int id);
}
