package com.nttdata.util;

import com.nttdata.domain.dao.Person;
import com.nttdata.domain.dao.util.ProfileType;
import com.nttdata.domain.request.PersonRequest;

import java.time.LocalDateTime;
import java.util.UUID;

public class PersonControllerDataTestUtils {

    public static PersonRequest getMockPersonRequest(){
        PersonRequest personRequest=new PersonRequest();
        personRequest.setId(UUID.randomUUID().toString());
        personRequest.setDni("46598548");
        personRequest.setName("Jonathan");
        personRequest.setLastName("Mejia Bernal");
        personRequest.setProfileType(1);
        personRequest.setCreatedAt(LocalDateTime.now());
        personRequest.setModifiedAt(LocalDateTime.now());
        return personRequest;
    }
    public static Person getMockPerson(){
        Person person=new Person();
        person.setId(UUID.randomUUID().toString());
        person.setState(1);
        person.setName("Jonathan");
        person.setDni("46598548");
        person.setModifiedAt(LocalDateTime.now());
        person.setProfileType(ProfileType.VIP);
        person.setLastName("Mejia Bernal");
        person.setCreatedAt(LocalDateTime.now());
        return person;
    }
}
