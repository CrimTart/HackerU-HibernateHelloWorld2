package ru.hackeru.hibernate;

import java.util.List;

public interface DAO<T> {
    void add(T obj);
    void delete(T data);
    void update(T obj);
    List<T> getAll();
    T getById(int id);
}
