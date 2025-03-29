package com.madz.firstJobApp.company.impl;

import com.madz.firstJobApp.company.Company;
import com.madz.firstJobApp.company.CompanyRepository;
import com.madz.firstJobApp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(Company company,Long id) {
        return null;
    }
}
