package com.madz.firstJobApp.company;

import com.madz.firstJobApp.job.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    private String description;

    @OneToMany
    private List<Job>job;

    public Company() {
    }

    public Company(String name, Long companyId, String description) {
        name = name;
        this.companyId = companyId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        name = name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
