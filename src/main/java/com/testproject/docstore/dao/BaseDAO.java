package com.testproject.docstore.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDAO<T> {

    List<T> getAll();

    Optional<T> getById(String id);

    void save(T entity);

    void update(T entity);

    void removeById(String id);
}
