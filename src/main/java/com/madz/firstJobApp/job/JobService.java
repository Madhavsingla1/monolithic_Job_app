package com.madz.firstJobApp.job;

import java.util.List;

public interface JobService {

    List<Job>  findAll();
    void createJob(Job job);

    Job jobById(int id);

    boolean deleteById(long id);

    boolean updateJobById(long id, Job val);
}
