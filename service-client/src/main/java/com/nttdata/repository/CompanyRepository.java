package com.nttdata.repository;

import com.nttdata.domain.dao.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String> {
}
