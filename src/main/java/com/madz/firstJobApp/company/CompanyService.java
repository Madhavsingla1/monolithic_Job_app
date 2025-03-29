package com.madz.firstJobApp.company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    Company updateCompany(Company company,Long id);
}
