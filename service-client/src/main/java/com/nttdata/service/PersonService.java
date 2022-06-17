package com.nttdata.service;

import com.nttdata.domain.dao.Company;
import com.nttdata.domain.dao.Person;


import java.util.Optional;

public interface PersonService extends AbstractService<Person>{

    Optional<Person> findById(String id);
}