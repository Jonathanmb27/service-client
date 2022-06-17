package com.nttdata.service;

import com.nttdata.domain.dao.Client;

import java.util.List;
import java.util.Optional;

public interface AbstractService <T extends Client>{

    T create(T t);
    T update(T t);
    List<T>findAll();
    Optional<T> delete(T t);
}
