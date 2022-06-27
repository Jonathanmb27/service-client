package com.nttdata.service.impl;

import com.nttdata.domain.dao.Person;
import com.nttdata.repository.PersonRepository;
import com.nttdata.service.PersonService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @CachePut(value = "personCache")
    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Cacheable(value = "personCache")
    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @CacheEvict(value = "personCache")
    @Override
    public Optional<Person> delete(Person person) {
        Optional<Person> personOptional=personRepository.findById(person.getId());
        if(personOptional.isPresent()){
            personRepository.save(personOptional.get());
        }
        return Optional.empty();
    }

    @Cacheable(key = "#id",value = "personCache")

    @Override
    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }
}
