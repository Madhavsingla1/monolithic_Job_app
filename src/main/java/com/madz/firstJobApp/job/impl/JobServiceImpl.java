package com.madz.firstJobApp.job.impl;

import com.madz.firstJobApp.job.Job;
import com.madz.firstJobApp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();
    private Long jobId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(jobId++);
        jobs.add(job);
    }

    @Override
    public Job jobById(int id) {
        for(Job job : jobs) {
            if(job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(long id) {
        for(Job job : jobs) {
            if(job.getId() == id) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJobById(long id, Job val) {
        for(Job job : jobs) {
            if(job.getId() == id) {
                job.setDescription(val.getDescription());
                job.setLocation(val.getLocation());
                job.setMaxsalary(val.getMaxsalary());
                job.setMinsalary(val.getMinsalary());
                job.setTitle(val.getTitle());
                return true;
            }
        }
        return false;
    }
}
