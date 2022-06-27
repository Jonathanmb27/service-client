package com.nttdata.controller;

import com.nttdata.domain.dao.Company;
import com.nttdata.domain.request.CompanyRequest;
import com.nttdata.domain.response.CompanyResponse;
import com.nttdata.domain.util.todao.ConvertToDao;
import com.nttdata.handler.ClientException;
import com.nttdata.handler.RestExceptionHandler;
import com.nttdata.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final Logger LOGGER = LoggerFactory.getLogger("CompanyController");
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Company> create(@RequestBody CompanyRequest companyRequest) {
        Company company = ConvertToDao.toDao(companyRequest, new Company());
       Company companyC= companyService.create(company);
       if(companyC!=null) return Mono.just(companyC);
       else throw new RuntimeException();

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CompanyResponse> findAll() {
        return ConvertToDao.toDTO(companyService.findAll());

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody CompanyRequest companyRequest) {
        Optional<Company> company = companyService.findById(companyRequest.getId());
        if (company.isPresent()) {
            companyService
                    .update(ConvertToDao.toDao(companyRequest, company.get()));
        } else {
            throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la compañia con id: "+companyRequest.getId());
        }
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id){
      //  Company company=ConvertToDao.toDao(companyRequest, new Company());
        Optional<Company> companyOptional=companyService.findById(id);

        if (!companyOptional.isPresent()){
            throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la compañia con id: "+id);
        }else companyService.delete(companyOptional.get());
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CompanyResponse findById(@PathVariable(value = "id") String companyId){
        Optional<Company> company=companyService.findById(companyId);
        if (company.isPresent()){
            return  ConvertToDao.toCompanyResponse(company.get());
        }
        else throw new ClientException(HttpStatus.NOT_FOUND,"No se pudo encontrar la compañia con id: "+companyId);
    }


}
