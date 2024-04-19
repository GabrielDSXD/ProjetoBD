package com.ci.hatertruck.CRUD.dao;

import java.util.List;
import java.util.Optional;

public interface DAO <T>{

    void create(T t);

    List<T> read();

    void update(T t, int id);

    void delete(int id);

    Optional<T> selectById(int id);

    List<T> selectByString(String s);

}