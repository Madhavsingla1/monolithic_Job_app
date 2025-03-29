package com.madz.firstJobApp.job;


import jakarta.persistence.*;

@Entity
//@Table(name = "Job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String minsalary;
    private String maxsalary;
    private String location;

    public Job(String location, String maxsalary, String minsalary, String description, String title, long id) {
        this.location = location;
        this.maxsalary = maxsalary;
        this.minsalary = minsalary;
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public Job() {

    }

    public String getMinsalary() {
        return minsalary;
    }

    public void setMinsalary(String minsalary) {
        this.minsalary = minsalary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxsalary() {
        return maxsalary;
    }

    public void setMaxsalary(String maxsalary) {
        this.maxsalary = maxsalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
