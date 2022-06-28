package com.nttdata.controller;

import com.nttdata.domain.dao.Company;
import com.nttdata.domain.dao.Person;
import com.nttdata.domain.request.CompanyRequest;
import com.nttdata.domain.request.PersonRequest;
import com.nttdata.service.CompanyService;
import com.nttdata.service.PersonService;
import com.nttdata.util.CompanyControllerDataTestUtils;
import com.nttdata.util.PersonControllerDataTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

//@WebFluxTest
//@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompanyControllerTest {


    @Autowired
    WebTestClient webTestClient;


    @MockBean
    CompanyService companyService;
    @MockBean
    PersonService personService;

    CompanyRequest companyRequest;
    PersonRequest personRequest;
    Company company;
    Person person;

    @BeforeEach
    void before(){
        companyRequest= CompanyControllerDataTestUtils.getMockCompanyRequest();
        company=CompanyControllerDataTestUtils.getMockCompany();
        personRequest= PersonControllerDataTestUtils.getMockPersonRequest();
        person=PersonControllerDataTestUtils.getMockPerson();
    }
    @Test
    void testCreateCompany(){
        Mockito.when(companyService.create(company)).thenReturn(new Company());

        webTestClient.post()
                .uri("/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(companyRequest),CompanyRequest.class)
                .exchange()
                .expectStatus().isOk();


    }
    @Test
    void testCreatedPerson(){
        Mockito.when(personService.create(person)).thenReturn(new Person());
        webTestClient.post()
                .uri("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(personRequest),PersonRequest.class)
                .exchange()
                .expectStatus().isOk();
    }
}
