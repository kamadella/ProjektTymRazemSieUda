package org.example.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T,K> {
    void save(T t);
    void delete(T t);
    void remove(K id);
    void update(T t);
    Optional<T> findById(K id);
    List<T> findAll();
}
