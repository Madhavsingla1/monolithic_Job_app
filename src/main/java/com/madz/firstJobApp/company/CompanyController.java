package com.madz.firstJobApp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private  CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Added successfully",HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company,@PathVariable Long id){
            return new ResponseEntity<>("Company updated successfully", companyService.updateCompany(company,id)? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){

        return new ResponseEntity<>("Company Successfully Deleted",companyService.deleteCompanyById(id)?HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Company> companyByid(@PathVariable Long id){
        Company company = companyService.findCompanyById(id);

        if(company!=null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

}
