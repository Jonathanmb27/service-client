package com.nttdata.domain.util.todao;


import com.nttdata.domain.dao.Company;
import com.nttdata.domain.dao.Person;
import com.nttdata.domain.dao.util.ProfileType;
import com.nttdata.domain.request.CompanyRequest;
import com.nttdata.domain.request.PersonRequest;
import com.nttdata.domain.response.CompanyResponse;
import com.nttdata.domain.response.PersonResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToDao {


    public static Company toDao(CompanyRequest companyRequest, Company company){


        company.setId(companyRequest.getId());
        company.setRuc(companyRequest.getRuc());
        company.setName(companyRequest.getName());
        company.setModifiedAt(LocalDateTime.now());
        company.setState(companyRequest.getState());
        if(companyRequest.getProfileType()==2)
            company.setProfileType(ProfileType.PYME);
        else
            company.setProfileType(ProfileType.NONE);
        return company;
    }
    public static Person toPerson(PersonRequest personRequest, Person person){

        person.setDni(personRequest.getDni());
        person.setState(personRequest.getState());
        person.setName(personRequest.getName());
        person.setLastName(personRequest.getLastName());
        person.setModifiedAt(LocalDateTime.now());
        if(personRequest.getProfileType()==1)
            person.setProfileType(ProfileType.VIP);
        else
            person.setProfileType(ProfileType.NONE);
        return  person;
    }

    public static List<PersonResponse>toListPersons(List<Person> personList){

        return  personList.stream().map( res-> new PersonResponse(res.getId(),
                res.getDni(),
                res.getName(),
                res.getLastName(),
                res.getProfileType(),
                res.getCreatedAt(),
                res.getModifiedAt(),
                res.getState())).collect(Collectors.toList());
    }
    public static List<CompanyResponse> toDTO(List<Company> companies){
       return companies.stream()
               .map((res)->
                   new  CompanyResponse(res.getId(),
                           res.getName(),
                           res.getRuc(),
                           res.getProfileType(),
                           res.getCreatedAt())).collect(Collectors.toList());
    }
    public static CompanyResponse toCompanyResponse(Company company){
           CompanyResponse companyResponse=new CompanyResponse();
           companyResponse.setName(company.getName());
           companyResponse.setRuc(company.getRuc());
           companyResponse.setId(company.getId());
           companyResponse.setCreatedAt(company.getCreatedAt());
           companyResponse.setProfileType(company.getProfileType());
           return companyResponse;
    }
    public static PersonResponse toPersonResponse(Person person){
        PersonResponse personResponse=new PersonResponse();
        personResponse.setDni(person.getDni());
        personResponse.setCreatedAt(person.getCreatedAt());
        personResponse.setLastName(person.getLastName());
        personResponse.setName(person.getName());
        personResponse.setId(person.getId());
        personResponse.setModifiedAt(person.getModifiedAt());
        personResponse.setState(person.getState());
        personResponse.setProfileType(person.getProfileType());
        return personResponse;
    }
}
