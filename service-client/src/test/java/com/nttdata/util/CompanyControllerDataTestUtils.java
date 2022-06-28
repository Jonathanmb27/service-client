package com.nttdata.util;

import com.nttdata.domain.dao.Company;
import com.nttdata.domain.dao.util.ProfileType;
import com.nttdata.domain.request.CompanyRequest;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompanyControllerDataTestUtils {

    public static CompanyRequest getMockCompanyRequest(){
        CompanyRequest companyRequest=new CompanyRequest();
        companyRequest.setId(UUID.randomUUID().toString());
        companyRequest.setName("Innova");
        companyRequest.setRuc("20659856895");
        companyRequest.setProfileType(2);
        companyRequest.setState(1);
        return companyRequest;
    }
    public static Company getMockCompany(){
        Company company=new Company();
        company.setId(UUID.randomUUID().toString());
        company.setName("Innova");
        company.setCreatedAt(LocalDateTime.now());
        company.setModifiedAt(LocalDateTime.now());
        company.setState(1);
        company.setProfileType(ProfileType.PYME);
        company.setRuc("20659856895");
        return company;
    }
}
