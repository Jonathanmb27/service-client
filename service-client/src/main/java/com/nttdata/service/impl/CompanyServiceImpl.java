package com.nttdata.service.impl;

import com.nttdata.domain.dao.Company;
import com.nttdata.repository.CompanyRepository;
import com.nttdata.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final Logger LOGGER= LoggerFactory.getLogger("CompanyServiceImpl");
    private final CompanyRepository companyRepository;
    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }
    @Override
    public Company create(Company company) {

        return companyRepository.save(company);
    }

    @CachePut(value = "companyCache")
    @Override
    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Cacheable(value = "companyCache")
    @Override
    public List<Company> findAll() {
        LOGGER.info("# company data retrive ");
       return companyRepository.findAll();
    }

    @CacheEvict(value = "companyCache")
    @Override
    public Optional<Company> delete(Company company) {
        Optional<Company> companyOptional=companyRepository.findById(company.getId());
        if(companyOptional.isPresent()) {
          //  company.setState(0);
            companyRepository.save(company);
            return Optional.of(company);
        }else return Optional.empty();

    }

    @Cacheable(value = "companyCache",key = "#id")
    @Override
    public Optional<Company> findById(String id) {
        return companyRepository.findById(id);
    }
}
