package com.nttdata.repository;

import com.nttdata.domain.dao.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
