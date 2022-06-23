package com.nttdata.service.impl;

import com.nttdata.domain.dao.Person;
import com.nttdata.repository.PersonRepository;
import com.nttdata.service.PersonService;
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

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> delete(Person person) {
        Optional<Person> personOptional=personRepository.findById(person.getId());
        if(personOptional.isPresent()){
            personRepository.save(personOptional.get());
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> findById(String id) {
        return personRepository.findById(id);
    }
}
