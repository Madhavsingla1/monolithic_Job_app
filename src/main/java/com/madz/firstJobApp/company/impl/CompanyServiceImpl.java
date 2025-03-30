package com.madz.firstJobApp.company.impl;

import com.madz.firstJobApp.company.Company;
import com.madz.firstJobApp.company.CompanyRepository;
import com.madz.firstJobApp.company.CompanyService;
import com.madz.firstJobApp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Company company,Long id) {
        Optional<Company> JobOptional= companyRepository.findById(id);
        if(JobOptional.isPresent())
        {
            Company compnay_current = JobOptional.get();
            compnay_current.setDescription(company.getDescription());
            compnay_current.setName(company.getName());
            compnay_current.setJob(company.getJob());
            companyRepository.save(compnay_current);
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        if(companyRepository.existsById(id))
        {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
