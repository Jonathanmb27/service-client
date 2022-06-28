package com.nttdata.service;

import com.nttdata.domain.dao.Company;

import java.util.Optional;

public interface CompanyService extends AbstractService<Company>{

    Optional<Company> findById(String id);
}
