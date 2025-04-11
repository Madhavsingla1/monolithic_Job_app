package com.madz.firstJobApp.job.impl;

import com.madz.firstJobApp.job.Job;
import com.madz.firstJobApp.job.JobRepository;
import com.madz.firstJobApp.job.JobService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

//    private List<Job> jobs = new ArrayList<Job>();

    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

//    private Long jobId = 1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
//        job.setId(jobId++);
        jobRepository.save(job);
    }

    @Override
    public Job jobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateJobById(long id, Job val) {

        Optional<Job>JobOptional= jobRepository.findById(id);
        if(JobOptional.isPresent())
        {
            Job job = JobOptional.get();
            job.setTitle(val.getTitle());
            job.setMaxsalary(val.getMaxsalary());
            job.setMinsalary(val.getMinsalary());
            job.setLocation(val.getLocation());
            job.setDescription(val.getDescription());
            jobRepository.save(job);
            return true;
        }

        return false;
    }
}
