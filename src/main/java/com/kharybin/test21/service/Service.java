package com.kharybin.test21.service;

import java.util.List;

public interface Service <T> {

    void add(T dataObj);

    void edit(Long id, T newobj);

    void delete(Long id);

    List<T> getAll();

    List<T> getById(Long id);
}
