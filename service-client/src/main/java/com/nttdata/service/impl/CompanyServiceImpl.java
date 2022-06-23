package com.nttdata.service.impl;

import com.nttdata.domain.dao.Company;
import com.nttdata.repository.CompanyRepository;
import com.nttdata.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @Override
    public Company create(Company company) {

        return companyRepository.save(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public List<Company> findAll() {

       return companyRepository.findAll();
    }

    @Override
    public Optional<Company> delete(Company company) {
        Optional<Company> companyOptional=companyRepository.findById(company.getId());
        if(companyOptional.isPresent()) {
          //  company.setState(0);
            companyRepository.save(company);
            return Optional.of(company);
        }else return Optional.empty();

    }

    @Override
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }
}
