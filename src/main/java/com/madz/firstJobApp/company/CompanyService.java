package com.madz.firstJobApp.company;

import com.madz.firstJobApp.job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    void createCompany(Company company);
    boolean updateCompany(Company company,Long id);
    boolean deleteCompanyById(Long id);
    Company findCompanyById(Long id);
}
