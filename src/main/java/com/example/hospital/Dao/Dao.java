package com.example.hospital.Dao;

import java.util.List;

public interface Dao<T>{
    T saveEntity(T t );
    T updateEntity(T t );
    void deleteById(Long id);
    List<T> getAll() ;
    T getById(Long id);
}
