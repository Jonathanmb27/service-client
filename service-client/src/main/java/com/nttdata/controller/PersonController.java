package com.nttdata.controller;

import com.nttdata.domain.dao.Person;
import com.nttdata.domain.request.PersonRequest;
import com.nttdata.domain.response.PersonResponse;
import com.nttdata.domain.util.todao.ConvertToDao;
import com.nttdata.handler.ClientException;
import com.nttdata.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;
    public PersonController(PersonService personService){
        this.personService=personService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void create(@RequestBody PersonRequest personRequest){
        Person person= ConvertToDao.toPerson(personRequest, new Person());
        if(personService.create(person)==null){
            throw new ClientException(HttpStatus.INTERNAL_SERVER_ERROR,"no se guardo correctamente");
        }
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> findAll(){
        return ConvertToDao.toListPersons(personService.findAll());
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody PersonRequest personRequest){
        Optional<Person> person=personService.findById(personRequest.getId());
        if(person.isPresent()){
            personService.update(ConvertToDao.toPerson(personRequest,person.get()));
        }
        else throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+personRequest.getId());

    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable String id){
        Optional<Person> person=personService.findById(id);
        if(person.isPresent()){
            personService.delete(person.get());
        }else throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+id);
    }
    @GetMapping(path = "/{id}")
    public PersonResponse findById(@PathVariable String id){
        Optional<Person> person=personService.findById(id);
        if(person.isPresent()){
            return ConvertToDao.toPersonResponse(person.get());
        }else throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la persona con id: "+id);
    }
}
